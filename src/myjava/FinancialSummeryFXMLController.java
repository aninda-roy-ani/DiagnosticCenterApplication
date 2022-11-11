/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.DocumentProperties;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.awt.Font;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class FinancialSummeryFXMLController implements Initializable {

    /*
    ObservableList<Revenue> revs = FXCollections.observableArrayList();
    private TableView<Revenue> table;
    private TableColumn<Revenue, String> year;
    private TableColumn<Revenue, String> revenue;
    private TableColumn<Revenue, String> month;
    private TextField revenueTF;
    private TextField monthTF;
    private TextField yearTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    


/*
    private void addToDatabaseAction(ActionEvent event) {
        
        
        //revs.add(rev);
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Revenue.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Revenue rev = new Revenue(  
                    yearTF.getText(),
                    revenueTF.getText(),
                    monthTF.getText()
            );
            System.out.println(rev.toString());
            oos.writeObject(rev);
            System.out.println(rev.toString());

        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        yearTF.setText(null);    monthTF.setText(null);   revenueTF.setText(null);  
    }

    private void showInTableAction(ActionEvent event) {
        String userID = User.findLoggedInID();
        Accountant accountant = new Accountant(userID);
        Revenue[] rev2 = accountant.generateFinancialSummery();
        System.out.println("x4");
        revs.addAll(Arrays.asList(rev2));
        table.setItems(revs);
        System.out.println(rev2.getBestMonth());
        
        ObjectInputStream ois=null;
        try {
            Revenue r;
            ois = new ObjectInputStream(new FileInputStream("Revenue.bin"));
            r = (Revenue) ois.readObject();
             System.out.println("here");
            table.getItems().add(r);
             System.out.println(r.toString());
             System.out.println("here");
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        } 
    }*/
    
    @FXML
    private void createPDFAction(ActionEvent event) {
        try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
            File f = fc.showSaveDialog(null);
            if(f!=null){              
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
               
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                String paraText1 
                        = "This is the financial summery of the diagnostic center.\n"
                        + "The table below shows the revenues of last 4 years.\n";
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("MODERN DIAGNOSTIC CENTER");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    
                
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
                Text title = new Text("Name of our honorable supervisors:").setFont(fontBold);
                title.setFontColor(Color.BLUE);
                Paragraph highestRevInfo = new Paragraph().add(title);
                
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                doc.add(highestRevInfo);
                //doc.add(lineSpace);
                
                
                List supervisorList = new List();
                supervisorList.add("Mr. Mostafa Kamal");
                supervisorList.add("Mrs. Nushrat Nahar");
                supervisorList.add("Mr. Ahmed Saif");
                
                doc.add(supervisorList);
                doc.add(lineSpace);
                
                
                float colWidthArr[] = {70f, 200f, 200f};
                Table pdfTable = new Table(colWidthArr); 
                
                
                Cell cell_00 = new Cell(); 
                cell_00.add("Year");
                cell_00.setBackgroundColor(Color.GREEN);
                pdfTable.addCell(cell_00);
                pdfTable.addCell(new Cell().setBackgroundColor(Color.GREEN).add("Revenue"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.GREEN).add("Highest Month"));
                
                pdfTable.addCell(new Cell().add("2018"));
                pdfTable.addCell(new Cell().add("21758900.00"));
                pdfTable.addCell(new Cell().add("December"));

                pdfTable.addCell(new Cell().add("2019"));
                pdfTable.addCell(new Cell().add("312567800.00"));
                pdfTable.addCell(new Cell().add("April"));

                pdfTable.addCell(new Cell().add("2020"));
                pdfTable.addCell(new Cell().add("500678970.00"));
                pdfTable.addCell(new Cell().add("May"));

                doc.add(pdfTable);
                
                doc.close();
                
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("The PDF is saved successfully.");
                a.showAndWait();    
            }
            else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Saving as PDF: cancelled!");
                a.showAndWait();               
            }
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Exception: " + e.toString()+ " occured.");
            a.showAndWait(); 
        }                           
    }
    
    
}
