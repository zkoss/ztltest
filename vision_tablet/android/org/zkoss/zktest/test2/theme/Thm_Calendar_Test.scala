package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Calendar_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<hlayout>
	<vlayout>
		<calendar id="cal1" />
		<datebox  id="db" width="200px" format="yyyy/MM/dd a hh:mm:ss"
			displayedTimeZones="GMT+8,GMT-8" />
	</vlayout>
	<vlayout>
		<calendar id="cal2" weekOfYear="true"/>
		<datebox  weekOfYear="true"/>
		<zscript>
			import java.util.Date;
			import java.util.Calendar;
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH,  Calendar.OCTOBER);
			cal.set(Calendar.DATE,   11);
			cal.set(Calendar.YEAR,   2012);
			cal.set(Calendar.HOUR,   5);
			cal.set(Calendar.MINUTE, 17);
			cal.set(Calendar.SECOND, 04);
			cal.set(Calendar.AM_PM,  Calendar.PM);

			Date date = cal.getTime(); 
			db.value = cal1.value = cal2.value = date;
		</zscript>
	</vlayout>
</hlayout>			
		""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Show 1st datebox's popup
				singleTap(jq(".z-datebox:eq(0)").toWidget().$n("btn"));
				sleep(500);
				verifyImage();
				
				// Show 2nd datebox's popup
				singleTap(jq(".z-datebox:eq(1)").toWidget().$n("btn"));
				sleep(500);
				verifyImage();
			});
	}
}