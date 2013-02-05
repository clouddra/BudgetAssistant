import java.util.*;

class BudgetAssistant {
	private int N; 
	private Vector<Item> allItems;
	private int budget, minBudget = 0 ;
	private int memo[][] ; // satisfaction table
	private int list[][] ;

	public BudgetAssistant() {
		allItems = new Vector<Item>() ;
	}

	public void calculate() {
		memo = new int[N+1][budget+1] ;
		list =  new int[N+1][budget+1] ;

		for (int i=0 ; i<N+1 ; i++) {
			Arrays.fill(memo[i], 0) ;
			Arrays.fill(list[i], 0) ;
		}

		for (int spend = 0; spend <= budget; spend++){
			for (int i = 1; i <= N; i++) 
			{
				Item currentItem = allItems.get(i) ;
				if (currentItem.getPrice() <= spend && currentItem.getSatisfaction() + memo[i-1][spend-currentItem.getPrice()] >= memo[i-1][spend])
				{	
					if (currentItem.getSatisfaction() + memo[i-1][spend-currentItem.getPrice()] > memo[i-1][spend])
						list[i][spend]=1 ;	// take item
					else 
						list[i][spend]=2 ;	// 2 choices: take or don't take

					memo[i][spend] = currentItem.getSatisfaction() + memo[i-1][spend-currentItem.getPrice()] ;
				}
				else {
					memo[i][spend] = memo[i-1][spend] ;
					list[i][spend]=0 ;	// don't take
				}
			}
		}

	}

	void print(){		
		int max = memo[N][budget] ;
		System.out.println("Buy:") ;
		Vector<Integer> test = new Vector<Integer>() ;

		for (int j=1 ; j<=budget ; j++) // find min budget
			if (memo[N][j]== max) {
				minBudget = j ;
				break ;
			}
		
		int sol = print(N, budget, test) ;
		
		System.out.println("-----------------------") ;
		System.out.println("There are a total of " + sol + " solution(s) with satisfaction optimised.") ;

	}

	int print(int i, int n, Vector<Integer> trace){
		if (i==0){
			System.out.println("-----------------------") ;
			int satisfaction = 0 ;
			int spent = 0 ;
			for (int j=0 ; j<trace.size() ; j++) {
				Item temp=allItems.get(trace.get(j));
				System.out.printf("%s for $%.2f ", temp.getName(), temp.getPrice()/100.0) ;
				System.out.println("(" + temp.getSatisfaction() + " satisfaction)") ;
				satisfaction+=temp.getSatisfaction() ;
				spent += temp.getPrice() ;
			}
			System.out.println() ;
			System.out.print("Satisfaction: ") ;
			System.out.println(satisfaction) ;
			System.out.print("Spent: ") ;
			System.out.printf("$%.2f", spent/100.0) ;
			if (spent==minBudget)
				System.out.print(" (Minimum Budget)") ;
			System.out.println() ;
			satisfaction = 0 ;
			spent = 0 ;
			return 1 ;
		}

		if (list[i][n]==1) {	
			trace.add(i) ;
			return print(i-1, n-allItems.get(i).getPrice(), trace) ;
		}

		if (list[i][n]==2) {	// we split into 2 branches here
			Vector<Integer> trace2 = new Vector<Integer>() ;
			trace2.setSize(trace.size()) ;
			Collections.copy(trace2, trace) ;
			trace.add(i) ;
			return print(i-1, n-allItems.get(i).getPrice(), trace) + print(i-1, n, trace2) ;
		} 
		return print(i-1, n, trace) ;

	}


	void preProcess() {
		String name ;
		int price, sum=0 ;
		int satisfaction ;

		Scanner sc = new Scanner(System.in);
		allItems.add(0, new Item("NULL", 0, 0)) ;	// dummy value for item 0
		N = sc.nextInt(); 
		for (int i = 0; i < N; i++){
			name = sc.next() ;
			price = (int)(sc.nextDouble()*100) ;
			satisfaction = sc.nextInt() ;
			allItems.add(new Item(name, price, satisfaction)) ;
			sum += price ;
		}

		System.out.print("Budget: ") ;
		budget = (int)(sc.nextDouble()*100) ;

		while (budget > sum) {
			System.out.print("Please enter an amount not larger than the total price of all the items: ");
			budget = (int)(sc.nextDouble()*100) ;
		}
	}

	public static void main(String[] args) {
		BudgetAssistant ITFair = new BudgetAssistant();
		ITFair.preProcess();		
		ITFair.calculate();		
		ITFair.print() ;
	}
}
