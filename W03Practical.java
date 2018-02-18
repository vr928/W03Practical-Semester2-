import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

//outlining W03Practical Class and its variables
public class W03Practical {
    private static final String MAXPRICE = "Maximum priced Invoice Number: ";
    private static final String MINPRICE = "Minimum priced Invoice Number: ";
    private static final String SPLITTER = ",";
    //main method
    public static void main(String[] args) {
        W03Practical practical = new W03Practical();
        practical.useReader(args);
    }
        //method to read data from a CSV file using BufferedReader
        public void useReader(String[]args) {
            String line;
            double min = 10000000;
            double max = 0;
            BufferedReader br = null;
            String minInvoiceNo = "";
            String maxInvoiceNo = "";
            PrintWriter p = null;
            DecimalFormat df = new DecimalFormat("0.00");

            try {
                //reading the csv file
                br = new BufferedReader(new FileReader(args[0]));
                p = new PrintWriter(args[1], "UTF-8");

                ArrayList<StockItem> stockList = new ArrayList<StockItem>();
                line = br.readLine();
                String[] headers = line.split(SPLITTER);
                while ((line = br.readLine()) != null) {
                    String[] StockDetails = line.split(SPLITTER);
                    stockList.add(new StockItem(StockDetails[0], StockDetails[1], StockDetails[2],
                            Integer.parseInt(StockDetails[3]), StockDetails[4],
                            Double.parseDouble(StockDetails[5]), StockDetails[6],
                            StockDetails[7]));
                }

                String previousInvoiceNo = stockList.get(0).getInvoiceNo();
                int totalItems = stockList.get(0).getQuantity();
                double totalPrice = stockList.get(0).getUnitPrice() * totalItems;
                p.println("Invoice Number: " + stockList.get(0).getInvoiceNo());
                p.println("Stock Code: " + stockList.get(0).getStockCode());
                p.println("Description: " + stockList.get(0).getDescription());
                p.println("Quantity: " + stockList.get(0).getQuantity());
                p.println("Unit Price: " + df.format(stockList.get(0).getUnitPrice()));
                previousInvoiceNo = stockList.get(0).getInvoiceNo();


                for (int i = 1; i < stockList.size(); i++) {
                    //       min = stockList.get(i);
                    //     max = stockList.get(i);
                    if (!previousInvoiceNo.equals(stockList.get(i).getInvoiceNo())) {
                        p.println("Number of items: " + totalItems);
                        p.println("Total Price: " + df.format(totalPrice));
                        p.println();
                        if (totalPrice > max && previousInvoiceNo.charAt(0) != 'C') {
                            max = totalPrice;
                            maxInvoiceNo = previousInvoiceNo;
                        }
                        if (totalPrice < min && previousInvoiceNo.charAt(0) != 'C' && totalPrice != 0) {
                            min = totalPrice;
                            minInvoiceNo = previousInvoiceNo;
                        }
                        totalItems = 0;
                        totalPrice = 0;
                    }

                    p.println("Invoice Number: " + stockList.get(i).getInvoiceNo());
                    p.println("Stock Code: " + stockList.get(i).getStockCode());
                    p.println("Description: " + stockList.get(i).getDescription());
                    p.println("Quantity: " + stockList.get(i).getQuantity());
                    p.println("Unit Price: " + df.format(stockList.get(i).getUnitPrice()));
                    previousInvoiceNo = stockList.get(i).getInvoiceNo();
                    totalItems += stockList.get(i).getQuantity();
                    totalPrice += stockList.get(i).getUnitPrice() * stockList.get(i).getQuantity();
                }
                p.println("Number of items: " + totalItems);
                p.println("Total Price: " + df.format(totalPrice));
                p.println();
                if (totalPrice > max) {
                    max = totalPrice;
                    maxInvoiceNo = previousInvoiceNo;
                }
                if (totalPrice < min) {
                    min = (totalPrice);
                    minInvoiceNo = previousInvoiceNo;
                }
                    p.println(MINPRICE + minInvoiceNo + " with " + df.format(min));
                    p.println(MAXPRICE + maxInvoiceNo + " with " + df.format(max));
                    p.close();
            }

            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Usage: java W03Practical <input_file> <output_file>");
            }
    }
}
