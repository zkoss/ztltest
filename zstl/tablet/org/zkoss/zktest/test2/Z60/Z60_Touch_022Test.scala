package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.openqa.selenium.interactions.HasTouchScreen
import org.openqa.selenium.By
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.interactions.touch.FlickAction
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_022Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() {
		val zscript = """
<zk xmlns:a="client/attribute">
	1.Swipe up/down to change year.  2.Swipe left/right to change month.
	<calendar width="400px" a:data-swipeable="true"/>
</zk>
		};
		
		runZTL(zscript,
			() => {
				val month_number = 
					Map("Jan" -> 1, "Feb" -> 2,	 "Mar" -> 3,  "Apr" -> 4,
						"May" -> 5, "Jun" -> 6,	 "Jul" -> 7,  "Aug" -> 8,
						"Sep" -> 9,	"Oct" -> 10, "Nov" -> 11, "Dec" -> 12
					);
				var calendar = jq(".z-calendar");
				var month_year = jq(".z-calendar-title span");
				var month_span = month_year.eq(0);
				var year_span  = month_year.eq(1);
				
				var month_before = month_number(month_span.text());
				var year_before  = year_span.text().toInt;

				// Previous Year
				swipeDown(calendar, 100);
				waitResponse(true);
				
				var month_after = month_number(month_span.text());
				var year_after  = year_span.text().toInt;
				
				verifyTrue(month_after == month_before && year_after == year_before-1);
				
				month_before = month_after;
				year_before = year_after;
				
				// Previous Month
				swipeRight(calendar, 100);
				waitResponse(true);

				month_after = month_number(month_span.text());
				year_after  = year_span.text().toInt;
				
				if (month_before >= 2)
					verifyTrue(month_after == month_before-1 && year_after == year_before);
				else
					verifyTrue(month_after == 12 && year_after == year_before-1);
			}
		);
	}
}