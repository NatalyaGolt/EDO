import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCreationAndDeletionSvedenyaDdoSKo extends BeforeAndAfter {

    @Test
    public void ddoSKo_SuccessfulCreation() {

//        АВТОРИЗАЦИЯ
        edo.autorization();
//        ВЫБОР ДОКУМЕНТА "СВЕДЕНИЯ ДДО С КО" ДЛЯ СОЗДАНИЯ
        docChoise.chooseSvedenyaDdoSKoForCreation();
//        ЗАПОЛНЕНИЕ ДОКУМЕНТА "СВЕДЕНИЯ ДДО С КО"
        docFill.fillSvedenyaDdoSKo();
//        СОХРАНЕНИЕ ДОКУМЕНТА
        docFill.docSave();
//        ПРОВЕРКА НАЛИЧИЯ ДОКУМЕНТА В БД
        Assert.assertTrue(dbQuery.findDdoSKoinDb(docFill.getDocMonth(), docFill.getDocYear()), "Документ не найден в БД");
        //    ВОЗВРАТ К РАБОЧЕМУ СТОЛУ ДОКУМЕНТОВ
        docFill.backToDocList();
//        ПРОВЕРКА НАЛИЧИЯ ДОКУМЕНТА НА РАБОЧЕМ СТОЛЕ
//        doc.docCreationAssert();
    }

    @Test
    public void ddoSKo_Assert() {
        Assert.assertEquals(dbQuery.findInnOrganizationDdoSKoinDb(), "7830002078");
    }

    @Test(dependsOnMethods = "ddoSKo_SuccessfulCreation")
    public void ddoSKo_SuccessfulDeletion() {

//        УДАЛЕНИЕ ПОСЛЕДНЕГО СОХРАНЕННОГО ДОКУМЕНТА
        docContextMenu.delete();
//        ПРОВЕРКА ОТСУТСТВИЯ ДОКУМЕНТА В БД
        Assert.assertFalse(dbQuery.findDdoSKoinDb(FillSvedenyaDdoSKO.docMonth, FillSvedenyaDdoSKO.docYear), "Документ не удален из БД");

    }

}
