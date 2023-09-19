//Max Dupler
//CSE 174
//Using Java to predict profits
//Sept. 3rd
public class ProjectProfits {
    public static void main(String[] args) {
        
        final int PREDICTED_INCOME1 = 2000000;
        final int PREDICTED_INCOME2 = 2500000;
        final int PREDICTED_INCOME3 = 3000000;
        final int PREDICTED_INCOME4 = 4000000;
        
        //year 1 calculation
        float interest1 = .051f;
        float interest2 = .072f;
        float interest3 = .093f;
        float interest4 = .112f;
        
        float profit1 = PREDICTED_INCOME1 * interest1;
        float profit2 = PREDICTED_INCOME2 * interest2;
        float profit3 = PREDICTED_INCOME3 * interest3;
        float profit4 = PREDICTED_INCOME4 * interest4; 
        
        float yearProfit1 = (profit1 + profit2 + profit3 + profit4) / 4.0f;
        
        System.out.println("The average profit for the next year: " 
            + yearProfit1); 
        //year 1 finished
        
        //year 2
        interest1 = .06f;
        interest2 = .08f;
        interest3 = .101f;
        interest4 = .132f;
        
        profit1 = PREDICTED_INCOME1 * interest1;
        profit2 = PREDICTED_INCOME2 * interest2;
        profit3 = PREDICTED_INCOME3 * interest3;
        profit4 = PREDICTED_INCOME4 * interest4; 
        
        float yearProfit2 = (profit1 + profit2 + profit3 + profit4) / 4.0f;
        
        System.out.println("The average profit for the second year: " 
            + yearProfit2);
        //year 2 finish
        
        //year 3
        interest1 = .08f;
        interest2 = .105f;
        interest3 = .13f;
        interest4 = .168f;
        
        profit1 = PREDICTED_INCOME1 * interest1;
        profit2 = PREDICTED_INCOME2 * interest2;
        profit3 = PREDICTED_INCOME3 * interest3;
        profit4 = PREDICTED_INCOME4 * interest4;
        
        float yearProfit3 = (profit1 + profit2 + profit3 + profit4) / 4.0f; 
                               
        System.out.println("The average profit for the third year: " 
            + yearProfit3); 
        //year 3 finish
        
        System.out.println(""); //blank line
        
        //total profits
        float totalProfit = yearProfit1 + yearProfit2 + yearProfit3;
        
        System.out.println("Total profit in next 3 years: " 
            + (int) totalProfit); 
    }
}
        