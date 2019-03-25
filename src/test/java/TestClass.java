import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClass {

    public TestClass() throws IOException {
    }

    @Before
    public void setup(){
    System.setProperty("webdriver.chrome.driver","c:\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    }

    @Test
    public void  Test1() throws IOException {
    //driver.get("https://www.google.lt/");
    //driver.findElement(By.id("create_link")).click();
        System.out.println("Total numer of rows: " + sheet.getPhysicalNumberOfRows());
        for (int i= 0; i < sheet.getPhysicalNumberOfRows(); i++){
            sheet.getRow(i).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            sheet.getRow(i).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            System.out.println("CellA values: " + sheet.getRow(i).getCell(0));
            System.out.println("CellB values: " + sheet.getRow(i).getCell(1));
//          driver.findElement(By.xpath(".//*[@id='issuetype-field']")).clear();
//          driver.findElement(By.xpath(".//*[@id='issuetype-field']")).sendKeys("Story");
//          driver.findElement(By.xpath(".//*[@id='issuetype-field']")).sendKeys(Keys.TAB);
//          keyAction.keyDown(Keys.ALT).keyDown(Keys.SHIFT).sendKeys("s").keyUp(Keys.ALT).keyUp(Keys.SHIFT).perform();
            writer.write(cellA+ " Done"+"\r\n");
            writer.flush();
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
    private WebDriver driver;
    private Date date = new Date();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    private File outputFile = new File("C:\\Temp\\outputFile" + dateFormat.format(date) + ".txt");
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile, true)));
    private File inputFile = new File ("C:\\Temp\\TestExcel.xlsx");
    private FileInputStream inputStream = new FileInputStream(inputFile);
    private XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
    private XSSFSheet sheet = workbook.getSheetAt(0);
    private XSSFCell cellA;
    private XSSFCell cellB;
    private String userName = "user name: " + cellA;
    private String password = "password: " + cellB;
    private Actions keyAction = new Actions(driver);

}
