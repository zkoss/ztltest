package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Calendar extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<hlayout>
	<vlayout>
		<calendar id="cal1" />
		<datebox  id="db" width="200px" format="yyyy/MM/dd a hh:mm:ss"
			displayedTimeZones="GMT+8,GMT-8" />
		<zscript>
			import java.util.Date;
			import java.text.DateFormat;
			
			Date date = DateFormat.getDateTimeInstance().parse("October 11, 2012 5:17:04 PM"); 
			db.value = cal1.value = cal2.value = date;
		</zscript>
	</vlayout>
	<vlayout>
		<calendar id="cal2" weekOfYear="true"/>
		<datebox  weekOfYear="true"/>
	</vlayout>
</hlayout>			
		""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Show 1st datebox's popup
				singleTap(jq(".z-datebox-btn:eq(0)"));
				sleep(500);
				verifyImage();
				
				// Show 2nd datebox's popup
				singleTap(jq(".z-datebox-btn:eq(1)"));
				sleep(500);
				verifyImage();
			});
	}
}