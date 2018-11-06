package jarun.project.timesheet.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import jarun.project.timesheet.model.DaySheet;
import jarun.project.timesheet.model.WeekSheet;
import jarun.project.timesheet.service.TimesheetServiceImpl;

public class TimesheetServiceImplTest {

    private TimesheetServiceImpl service = new TimesheetServiceImpl();

    @SuppressWarnings("deprecation")
    @Test
    public void testGetBlankWeekSheet() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = formatter.parse("2015/12/29");
        WeekSheet weekSheet = service.getBlankWeekSheet(date, null, null);
        DaySheet first = weekSheet.getSheets().get(0);
        assertEquals(first.getDate().getDate(), 27);
    }
}
