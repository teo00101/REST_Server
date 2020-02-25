package pk1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClient {

	public static void main(String[] args) {
            String x="0";
            String id="";
            Impiegato imp=new Impiegato();
            do{
          
            try {
                  InputStreamReader tastiera= new InputStreamReader(System.in);
                  BufferedReader buff=new BufferedReader(tastiera);

                  System.out.println("Inserisci 0 per terminare la sessione\n"
                          + "Inserisci 1 per aggiungere\n"
                          + "Inserisci 2 per visualizzare\n"
                          + "Inserisci 3 per visualizzare uno specifico impiegato tramite id\n"
                          + "Inserisci 4 per eliminare un impiegato tramite id\n"
                          + "Inserisci 5 per sostituire uno specifico impiegato\n");
                  x=buff.readLine();

                  switch(x){
                      case "1":
                          URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
                          HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                          conn.setDoOutput(true);
                          conn.setRequestMethod("POST");
                          conn.setRequestProperty("Content-Type", "application/json");


                          System.out.println("Inserisci i dati della persona:\n");
                          System.out.println("Inserisci id");
                          imp.setId(Integer.parseInt(buff.readLine()));

                          System.out.println("Inserisci il nome");
                          imp.setNome(buff.readLine());

                          System.out.println("Inserisci il cognome");
                          imp.setCognome(buff.readLine());

                          System.out.println("Inserisci la mail");
                          imp.setMail(buff.readLine());

                          System.out.println("Inserisci il numero di telefono");
                          imp.setNumTel(buff.readLine());

                          String input = "{\n" +
                                          "  \"employeeId\": "+imp.getId()+",\n" +
                                          "  \"firstName\": \""+imp.getNome()+"\",\n" +
                                          "  \"lastName\": \""+imp.getCognome()+"\",\n" +
                                          "  \"email\": \""+imp.getMail()+"\",\n" +
                                          "  \"phone\": \""+imp.getNumTel()+"\"\n" +
                                          "}";
                          
                          

                          OutputStream os = conn.getOutputStream();
                          os.write(input.getBytes());
                          os.flush();

                          if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                                  throw new RuntimeException("Failed : HTTP error code : "
                                          + conn.getResponseCode());
                          }


                          conn.disconnect();
                          break;
                      case "2":
                          URL url2 = new URL("http://localhost:8080/api/tutorial/1.0/employees");
                          HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
                          conn2.setRequestMethod("GET");
                          conn2.setRequestProperty("Accept", "application/json");

                          if (conn2.getResponseCode() != 200) {
                                  throw new RuntimeException("Failed : HTTP error code : "
                                                  + conn2.getResponseCode());
                          }

                          BufferedReader br2 = new BufferedReader(new InputStreamReader(
                                  (conn2.getInputStream())));

                          String output2;
                          while ((output2 = br2.readLine()) != null) {
                                  System.out.println(output2);
                          }

                          conn2.disconnect();
                          break;
                      case "3":
                          System.out.println("Inserisci l'id dell'impiegato che vuoi visualizzare");
                          id=buff.readLine();
                          System.out.println("");
                          URL url3 = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+id);
                          HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();
                          conn3.setRequestMethod("GET");
                          conn3.setRequestProperty("Accept","*/*");

                          if (conn3.getResponseCode() != 200) {
                                  throw new RuntimeException("Failed : HTTP error code : "
                                                  + conn3.getResponseCode());
                          }

                          BufferedReader br3 = new BufferedReader(new InputStreamReader(
                                  (conn3.getInputStream())));

                          String output3;
                          while ((output3 = br3.readLine()) != null) {
                                  System.out.println(output3);
                          }

                          conn3.disconnect();    
                          break;
                         
                      case "4":
                          System.out.println("Inserisci l'id dell'impiegato che vuoi visualizzare");
                          id=buff.readLine();
                          System.out.println("");
                          URL url4 = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+id);
                          HttpURLConnection conn4 = (HttpURLConnection) url4.openConnection();
                          conn4.setRequestMethod("DELETE");
                          conn4.setRequestProperty("Accept","*/*");

                          if (conn4.getResponseCode() != 200) {
                                  throw new RuntimeException("Failed : HTTP error code : "
                                                  + conn4.getResponseCode());
                          }

                          BufferedReader br4 = new BufferedReader(new InputStreamReader(
                                  (conn4.getInputStream())));

                          String output4;
                          while ((output4 = br4.readLine()) != null) {
                                  System.out.println(output4);
                          }

                          conn4.disconnect();
                          break;
                      case "5":
                          System.out.println("Inserisci l'id dell'impiegato che vuoi sostituire");
                          id=buff.readLine();
                          System.out.println("");
                          URL url5 = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+id);
                          HttpURLConnection conn5 = (HttpURLConnection) url5.openConnection();
                          conn5.setDoOutput(true);
                          conn5.setRequestMethod("PUT");
                          conn5.setRequestProperty("Content-Type", "application/json");
                         

                          System.out.println("Inserisci i dati della persona:\n");
                          System.out.println("Inserisci id");
                          imp.setId(Integer.parseInt(buff.readLine()));

                          System.out.println("Inserisci il nome");
                          imp.setNome(buff.readLine());

                          System.out.println("Inserisci il cognome");
                          imp.setCognome(buff.readLine());

                          System.out.println("Inserisci la mail");
                          imp.setMail(buff.readLine());

                          System.out.println("Inserisci il numero di telefono");
                          imp.setNumTel(buff.readLine());

                          String input2 = "{\n" +
                                          "  \"employeeId\": "+imp.getId()+",\n" +
                                          "  \"firstName\": \""+imp.getNome()+"\",\n" +
                                          "  \"lastName\": \""+imp.getCognome()+"\",\n" +
                                          "  \"email\": \""+imp.getMail()+"\",\n" +
                                          "  \"phone\": \""+imp.getNumTel()+"\"\n" +
                                          "}";
                          
                          OutputStream os2 = conn5.getOutputStream();
                          os2.write(input2.getBytes());
                          os2.flush();
                         
                          
                          if (conn5.getResponseCode() != 200) {
                                  throw new RuntimeException("Failed : HTTP error code : "
                                                  + conn5.getResponseCode());
                          }


                          conn5.disconnect();
                          break;
                  }

                  System.out.println("");

            } catch (MalformedURLException e) {

                  e.printStackTrace();

            } catch (IOException e) {

                  e.printStackTrace();

           }


          }while(Integer.parseInt(x)!= 0);
        
        }
}
