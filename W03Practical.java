import java.io.*; 

import java.util.ArrayList; 

  

public class W03Practical { 

    private static final String MAXPRICE = "Number of the invoice with maximum price: "; 

    private static final String MINPRICE = "Number of the invoice with minimum price: "; 

    private static final String SPLITTER = ","; 

    public static void main(String args[]) { 

        W03Practical practical = new W03Practical(); 

        practical.UseReader(args); 

    } 

  

        public void UseReader(String[]args) { 

            String line; 

            StockItem min; 

            StockItem max; 

  

            try{ 

                //reading the csv file 

                BufferedReader br = new BufferedReader(new FileReader("data-medium.csv")); 

                PrintWriter p = new PrintWriter("output.txt","UTF-8"); 

  

                ArrayList<StockItem> stockList = new ArrayList<StockItem>(); 

                line = br.readLine(); 

                String[]Headers=line.split(SPLITTER); 

                while ((line = br.readLine()) != null) 

                { 

                    String [] StockDetails = line.split(SPLITTER); 

                    stockList.add(new StockItem(StockDetails[0],StockDetails[1],StockDetails[2], 

                            Integer.parseInt(StockDetails[3]),StockDetails[4], 

                            Double.parseDouble(StockDetails[5]),StockDetails[6], 

                            StockDetails[7])); 

                } 

  

                for(int i = 0; i<stockList.size();i++){ 

                    if(i==0){ 

                        min = stockList.get(i); 

                        max = stockList.get(i); 

                    } 

                    p.println("Invoice Number: " + stockList.get(i).getInvoiceNo()); 

                    p.println("Stock Code: " + stockList.get(i).getStockCode()); 

                    p.println("Description: " + stockList.get(i).getDescription()); 

                    p.println("Quantity: " + stockList.get(i).getQuantity()); 

                    p.println("Unit Price: " + stockList.get(i).getUnitPrice()); 

                } 

                p.println(MINPRICE); 

                p.println(MAXPRICE); 

                p.close(); 

  

            } 

            catch(FileNotFoundException e) { 

                e.printStackTrace(); 

            }catch(IOException e) { 

                e.printStackTrace(); 

            }catch(ArrayIndexOutOfBoundsException e) { 

                //usage java 

            } 

    } 

} 