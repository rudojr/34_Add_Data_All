import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import java.sql.Time
import java.util.concurrent.TimeUnit

import java.io.InputStream
import java.io.FileInputStream

static def setUp(url)
{
    System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe")
    WebDriver driver = new ChromeDriver()
    driver.navigate().to(url)
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
}

static def login(driver, username, password)
{
    WebElement inputUser = driver.findElement(By.xpath("//input[@field='email']"))
    WebElement inputPassword = driver.findElement(By.xpath("//input[@field='password']"))
    inputUser.sendKeys(username)
    inputPassword.sendKeys(password)
    Time.sleep(2000)
}
///////////////////////////////Quản lý phòng////////////////////////////////
static def create_list_room(driver, name, capacity, manager, prepare)
{
    WebElement btnAdd = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable {By.xpath("//span[@data-name='btnAdd']") })
    btnAdd.click()
    Time.sleep(1000)
    WebElement room_name = driver.findElement(By.xpath("//input[@placeholder='Nhập tên phòng họp...']"))
    WebElement room_capacity = driver.findElement(By.xpath("//input[@placeholder='Nhập sức chứa (người)...']"))
    Time.sleep(2000)
    WebElement btnSave = driver.findElement(By.xpath("//span[@data-name='lblSave']"))
    room_name.sendKeys(name)
    room_capacity.sendKeys(capacity)
    btnSave.click()
    Time.sleep(1000)
    driver.navigate().refresh()
}
static def create_list_room_reason(driver, reason)
{
    WebElement btnAdd = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-name='btnAdd']")))
    btnAdd.click()
    Time.sleep(1000)
    WebElement room_reason = driver.findElement(By.xpath("//input[@placeholder='Nhập lý do...']"))
    WebElement btnSave =  driver.findElement(By.xpath("//button[text()=' Lưu ']"))
    room_reason.sendKeys(reason)
    btnSave.click()
    Time.sleep(1000)
    driver.navigate().refresh()
}
///////////////////////////////Quản lí xe////////////////////////////////////////////
static def create_list_car(driver, car_name, car_seats)
{
    WebElement btnAdd = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-name='btnAdd']")))
    btnAdd.click()
    Time.sleep(1000)
    WebElement icar_name = driver.findElement(By.xpath("//input[@placeholder='Nhập tên xe...']"))
    WebElement icar_seats =  driver.findElement(By.xpath("//input[@placeholder='Nhập số chỗ...']"))
    WebElement btnSave = driver.findElement(By.xpath("//span[@data-name='lblSave']"))
    icar_name.sendKeys(car_name)
    icar_seats.sendKeys(car_seats)
    btnSave.click()
    Time.sleep(2000)
    driver.navigate().refresh()
}
static def create_list_car_driver(driver, name_driver, car_name)
{
    WebElement btnAdd = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-name='btnAdd']")))
    btnAdd.click()
    WebElement iname_driver = driver.findElement(By.xpath("//input[@placeholder='Nhập tên tài xế...']"))
    iname_driver.sendKeys(name_driver)
    WebElement cb_unit = driver.findElement(By.xpath("/html/body/lib-layoutnoaside/div[1]/div/aside/popup-add-resources/codx-form/div/div[2]/div[4]/div/codx-input/codx-combobox/ejs-combobox/span/span"))
    cb_unit.click()
    WebElement iunit = driver.findElement(By.xpath("//div[@title='ORG-0000']"))
    iunit.click()
    WebElement idCar = driver.findElement(By.xpath("//input[@placeholder='Nhập mã xe...']"))
    idCar.sendKeys(car_name, Keys.DOWN, Keys.ENTER)
    Time.sleep(1000)
    WebElement btnSave = driver.findElement(By.xpath("//span[@data-name='lblSave']"))
    btnSave.click()
    Time.sleep(2000)
    driver.navigate().refresh()
}
static def create_list_car_card(driver, card_name)
{
    WebElement btnAdd = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-name='btnAdd']")))
    btnAdd.click()
    WebElement icard_name = driver.findElement(By.xpath("//input[@placeholder='Nhập tên thẻ...']"))
    WebElement btnSave = driver.findElement(By.xpath("//span[@data-name='lblSave']"))
    icard_name.sendKeys(card_name)
    btnSave.click()
    Time.sleep(2000)
    driver.navigate().refresh()
}
static def create_list_car_reason(driver,car_reason)
{
    WebElement btnAdd = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-name='btnAdd']")))
    btnAdd.click()
    WebElement ireason = driver.findElement(By.xpath("//input[@placeholder='Nhập lý do...']"))
    WebElement btnSave = driver.findElement(By.xpath("//span[@data-name='lblSave']"))
    ireason.sendKeys(car_reason)
    btnSave.click()
    Time.sleep(2000)
    driver.navigate().refresh()
}
///////////////////////////////////Quản lí VPP/////////////////////////////////////////////////
static def create_list_vpp_reason(driver, vpp_reason)
{
    WebElement btnAdd = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-name='btnAdd']")))
    btnAdd.click()
    WebElement lydo = driver.findElement(By.xpath("//input[@placeholder='Nhập lý do...']"))
    WebElement btnSave =  driver.findElement(By.xpath("//button[text()=' Lưu ']"))
    lydo.sendKeys(vpp_reason)
    btnSave.click()
    Time.sleep(1000)
    driver.navigate().refresh()
}
static def create_list_vpp_warehouse(driver, warehouse_name)
{
    WebElement btnAdd = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-name='btnAdd']")))
    btnAdd.click()
    WebElement wh_name = driver.findElement(By.xpath("//input[@placeholder='Nhập tên kho...']"))
    WebElement btnSave =  driver.findElement(By.xpath("//button[text()=' Lưu ']"))
    wh_name.sendKeys(warehouse_name)
    btnSave.click()
    Time.sleep(1000)
    driver.navigate().refresh()
}
static def create_list_vpp_unit(driver, unit_name)
{
    WebElement btnAdd = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-name='btnAdd']")))
    btnAdd.click()
    WebElement ten_dvt = driver.findElement(By.xpath("//input[@placeholder='Nhập tên đơn vị tính...']"))
    ten_dvt.sendKeys(unit_name)
    driver.findElement(By.xpath("//button[text()=' Lưu ']")).click()
    Time.sleep(2000)
    driver.navigate().refresh()
}
static def create_list_vpp_groupvpp(driver, group_name)
{
    WebElement btnAdd = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-name='btnAdd']")))
    btnAdd.click()
    WebElement groupvpp = driver.findElement(By.xpath("//input[@placeholder='Nhập tên  nhóm văn phòng phẩm...']"))
    WebElement btnSave =  driver.findElement(By.xpath("//button[text()=' Lưu ']"))
    groupvpp.sendKeys(group_name)
    btnSave.click()
    Time.sleep(1000)
    driver.navigate().refresh()
}
static def create_list_vpp(driver, vpp_name, vpp_unit,vpp_warehouse, vpp_groupvpp)
{
    WebElement btnAdd = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-name='btnAdd']")))
    btnAdd.click()
    WebElement name = driver.findElement(By.xpath("//input[@placeholder='Nhập tên văn phòng phẩm...']"))
    driver.findElement(By.xpath("/html/body/lib-layoutnoaside/div[1]/div/aside/popup-add-stationery/codx-layout-add/codx-form/div/div[2]/div[2]/div/div/div[1]/div/div[1]/div[2]/codx-input/codx-combobox/ejs-combobox/span/span"))
    WebElement unit =  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+vpp_unit+"']")))
    unit.click()
    Time.sleep(1000)
    driver.findElement(By.xpath("/html/body/lib-layoutnoaside/div[1]/div/aside/popup-add-stationery/codx-layout-add/codx-form/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div[1]/codx-input/codx-combobox/ejs-combobox/span/span")).click()
    WebElement grp =  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+vpp_groupvpp+"']")))
    grp.click()
    sleep(1000)
    driver.findElement(By.xpath("/html/body/lib-layoutnoaside/div[1]/div/aside/popup-add-stationery/codx-layout-add/codx-form/div/div[2]/div[2]/div/div/div[1]/div/div[3]/div/codx-input/codx-combobox/ejs-combobox/span/span")).click()
    WebElement wh =  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+vpp_warehouse+"']")))
    wh.click()
    Time.sleep(2000)
    driver.navigate().refresh()
}
//////////////////////////////////////////////////////////////////////////////////////////////
static def main() {
    String url_site = "http://172.16.7.34:8000/congtyqc/auth/login"
    String user = "mannhi1601@gmail.com"
    String pass = "admin"

    WebDriver driver = setUp(url_site)

    login(driver, user, pass)
    Time.sleep(2000)

    String epr_link = url_site + '/ep/report/EPR'
    driver.navigate().to(epr_link)
    Time.sleep(1000)

    String epr_setting = url_site + '/shared/settings/EPS'
    driver.navigate().to(epr_setting)
    //////////////////////////////
    String link_room_dm = url_site + '/ep/rooms/EPS21'
    driver.navigate().to(link_room_dm)
    String data_room_dm = "D:\\34_ADD_DatPhong.xlsx"
    Inputstream inp_room = new FileInputStream(data_room_dm)
    Workbook wb_room = WorkbookFactory.create(inp_room)
    Sheet list_room_dm = wb_room.getSheetAt(0)
    int count_list_room_dm = list_room_dm.getPhysicalNumberOfRows()
    for (int i = 1; i < count_list_room_dm; i++)
    {
        String name = list_room_dm.getRow(i).getCell(0).getStringCellValue()
        String capacity = list_room_dm.getRow(i).getCell(1).getStringCellValue()
        String manager = list_room_dm.getRow(i).getCell(2).getStringCellValue()
        String prepare = list_room_dm.getRow(i).getCell(3).getStringCellValue()
        create_list_room(driver, name, capacity,manager, prepare)
        Time.sleep(1000)
    }
    driver.navigate().back()
    String link_room_reason = url_site + '/shared/dynamic/EPS29'
    driver.navigate().to(link_room_reason)
    String list_lydo = wb.getSheet(1)
    int count_list_lydo = list_lydo.getPhysicalNumberOfRows()
    for (int i = 1; i < count_list_lydo; i++)
    {
        String reason = list_lydo.getRow(i).getCell(0).getStringCellValue()
        create_list_room_reason(driver,reason)
        Time.sleep(1000)
    }
    ///////////////////////////////////////////////////////////////////////////////
    driver.navigate().back()
    String link_car_list = url_site + '/ep/cars/EPS22'
    driver.navigate().to(link_car_list)
    Time.sleep(1000)
    String data_car_dm = "D:\\34_ADD_Datxe.xlsx"
    Inputstream inp_car = new FileInputStream(data_room_dm)
    Workbook wb_car = WorkbookFactory.create(inp_car)
    Sheet list_car = wb_car.getSheetAt(0)
    int count_list_car = list_car.getPhysicalNumberOfRows()
    for (int i = 0; i < count_list_car; i++)
    {
        String car_name = list_car.getRow(i).getCell(0).getStringCellValue()
        String car_seat = list_car.getRow(i).getCell(1).getStringCellValue()
        create_list_car(driver,car_name, car_seat)
        Time.sleep(1000)
    }
    driver.navigate().back()
    String link_list_car_driver = url_site + '/ep/drivers/EPS23'
    driver.navigate().to(link_list_car_driver)
    Time.sleep(1000)
    Sheet list_driver = wb_car.getSheetAt(1)
    int count_list_driver = list_driver.getPhysicalNumberOfRows()
    for (int i = 0; i < count_list_driver; i++)
    {
        String driver_name = list_driver.getRow(i).getCell(0).getStringCellValue()
        String carid = list_driver.getRow(i).getCell(1).getStringCellValue()
        create_list_car_driver(driver, driver_name, carid)
        sleep(1000)
    }
    driver.navigate().back()
    String link_list_car_card = url_site + '/ep/epcards/EPS25'
    driver.navigate().to(link_list_car_card)
    Time.sleep(1000)
    Sheet list_car_card = wb_car.getSheetAt(2)
    int count_list_car_card = list_car_card.getPhysicalNumberOfRows()
    for (int i = 0; i < count_list_car_card; i++)
    {
        String cardname = list_car_card.getRow(i).getCell(1).getStringCellValue()
        create_list_car_card(driver, cardname)
        Time.sleep(1000)
    }
    driver.navigate().back()
    String link_list_car_reason = url_site + '/shared/dynamic/EPS210'
    driver.navigate().to(link_list_car_reason)
    Time.sleep(1000)
    Sheet list_car_reason = wb_car.getSheet(3)
    int count_list_car_reason = list_car_reason.getPhysicalNumberOfRows()
    for (int i = 0; i < count_list_car_reason; i++)
    {
        String reason = list_car_reason.getRow(i).getCell(0).getStringCellValue()
        create_list_car_reason(driver, reason)
        Time.sleep(1000)
    }
    ///////////////////////////////////////////////////////////////////////////////
    driver.navigate().back()
    String link_list_vpp_reason = url_site + '/shared/dynamic/EPS211'
    driver.navigate().to(link_list_vpp_reason)
    Time.sleep(1000)
    String data_vpp_dm = "D:\\34_Add_VPP.xlsx"
    Inputstream inp_vpp = new FileInputStream(data_vpp_dm)
    Workbook wb_vpp = WorkbookFactory.create(inp_vpp)
    Sheet list_vpp_reason = wb_vpp.getSheetAt(0)
    int count_list_vpp_reason = list_vpp_reason.getPhysicalNumberOfRows()
    for (int i = 0; i < count_list_vpp_reason; i++)
    {
        String vpp_reason = list_vpp_reason.getRow(i).getCell(0).getStringCellValue()
        create_list_car(driver,vpp_reason)
        Time.sleep(1000)
    }
    driver.navigate().back()
    String link_list_vpp_warehouse = url_site + '/shared/dynamic/EPS28'
    driver.navigate().to(link_list_vpp_warehouse)
    Time.sleep(1000)
    Sheet list_vpp_warehouse = wb_vpp.getSheetAt(1)
    int count_list_vpp_warehouse = list_vpp_warehouse.getPhysicalNumberOfRows()
    for (int i = 0; i < count_list_vpp_warehouse; i++)
    {
        String wh_name = list_vpp_warehouse.getRow(i).getCell(0).getStringCellValue()
        create_list_vpp_warehouse(driver, wh_name)
        sleep(1000)
    }
    driver.navigate().back()
    String link_list_vpp_unit = url_site + '/shared/dynamic/EPS26'
    driver.navigate().to(link_list_vpp_warehouse)
    Time.sleep(1000)
    Sheet list_vpp_unit = wb_vpp.getSheetAt(2)
    int count_list_vpp_unit = list_vpp_unit.getPhysicalNumberOfRows()
    for (int i = 0; i < count_list_vpp_unit; i++)
    {
        String unitname = list_vpp_unit.getRow(i).getCell(0).getStringCellValue()
        create_list_vpp_unit(driver, unitname)
        Time.sleep(1000)
    }
    driver.navigate().back()
    String link_list_vpp_group = url_site + '/shared/dynamic/EPS27'
    driver.navigate().to(link_list_vpp_group)
    Time.sleep(1000)
    Sheet list_vpp_vpp_group = wb_vpp.getSheetAt(3)
    int count_list_vpp_group = list_vpp_vpp_group.getPhysicalNumberOfRows()
    for (int i = 0; i < count_list_vpp_group; i++)
    {
        String grpname = list_vpp_vpp_group.getRow(i).getCell(0).getStringCellValue()
        create_list_vpp_groupvpp(driver, grpname)
        sleep(1000)
    }
    driver.navigate().back()
    String link_list_vpp = url_site + '/shared/dynamic/EPS27'
    driver.navigate().to(link_list_vpp)
    sleep(1000)
    Sheet list_vpp = wb.getSheetAt(4)
    int count_list_vpp = list_vpp.getPhysicalNumberOfRows()
    for (int i = 0; i < count_list_vpp; i++)
    {
        String vpp_name = list_vpp.getRow(i).getCell(0).getStringCellValue()
        String vpp_unit = list_vpp.getRow(i).getCell(1).getStringCellValue()
        String vpp_wh = list_vpp.getRow(i).getCell(2).getStringCellValue()
        String vpp_group = list_vpp.getRow(i).getCell(3).getStringCellValue()
        create_list_vpp(driver, vpp_name, vpp_unit, vpp_wh, vpp_group)
        Time.sleep(1000)
    }
    print("Done !!!")
}