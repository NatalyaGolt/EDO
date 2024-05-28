import Pages.*;
import org.testng.annotations.Test;

public class TestCreationAndDeletionSvedenyaDdoSKo extends BeforeAndAfter {

    @Test
    public void ddoSKo_SuccessfulCreationAndDeletion() throws InterruptedException {

        var edo = new Pages.Autorization(driver, wait);
        var docChoise = new Pages.NewDocumentCreationChoose(driver, wait);
        var docFill = new FillSvedenyaDdoSKO(driver, wait);
        var doc = new Pages.Desktop(driver, wait);
        var docContextMenu = new Pages.DocContextMenu(driver, wait);

//        АВТОРИЗАЦИЯ
        edo.autorization();
//        ВЫБОР ДОКУМЕНТА "СВЕДЕНИЯ ДДО С КО" ДЛЯ СОЗДАНИЯ
        docChoise.chooseSvedenyaDdoSKoForCreation();
//        ЗАПОЛНЕНИЕ ДОКУМЕНТА "СВЕДЕНИЯ ДДО С КО"
        docFill.fillSvedenyaDdoSKo();
//        СОХРАНЕНИЕ ДОКУМЕНТА
        docFill.docSave();
//        ВОЗВРАТ К РАБОЧЕМУ СТОЛУ ДОКУМЕНТОВ
        docFill.backToDocList();
//        ПРОВЕРКА НАЛИЧИЯ ДОКУМЕНТА НА РАБОЧЕМ СТОЛЕ
        doc.docCreationAssert();
//        УДАЛЕНИЕ ПОСЛЕДНЕГО СОХРАНЕННОГО ДОКУМЕНТА
        docContextMenu.delete();

    }
}
