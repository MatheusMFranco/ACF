package br.com.alreadyhas.cf.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.alreadyhas.cf.base.SimpleTest;

public class DateUtilTest extends SimpleTest{

	@Test
	public void verifyDateFormat(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Date[] dates = {
				new Date(), 
				Calendar.getInstance().getTime(),
		};

		List<String> datesTest      = new ArrayList<String>();
		List<String> datesExpecteds = new ArrayList<String>();

		for(Date date : dates){
			datesTest.add(DateUtil.getDefaultFormat(date));
			datesExpecteds.add(dateFormat.format(date));
		}

		datesTest.add(DateUtil.getDefaultFormat());
		datesExpecteds.add(dateFormat.format(new Date()));

		equalsToArray(datesTest, datesExpecteds);
	}

}
