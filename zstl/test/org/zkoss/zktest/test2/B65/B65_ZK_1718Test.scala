package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1718.zul")
class B65_ZK_1718Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	Open the calendar, should see the "dates" after 2013/4/20 are disabled.
	<zscript><![CDATA[
		import java.util.Calendar;
		import java.util.Date;
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 3, 19);
		Date date = cal.getTime();
	]]></zscript>
	<datebox width="150px" value="${date}" constraint="no empty, before 20130420" />
</zk>"""  
  runZTL(zscript,
    () => {
      val db = jq(".z-datebox:eq(0)").toWidget()
      click(db.$n("btn"))
      waitResponse()
      
      21 to 30 foreach { n =>
      	verifyTrue("should see the 2013/4/" + n + " after 2013/4/20 are disabled.", 
      	    jq(".z-calendar-body td:contains(" + n + ")").hasClass("z-calendar-disabled"))
      }      
    })
    
  }
}