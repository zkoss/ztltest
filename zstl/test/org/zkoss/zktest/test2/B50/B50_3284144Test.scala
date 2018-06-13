/* B50_3284144Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3284144Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<h:pre xmlns:h="xhtml" >
	
		Click each datebox's button , and check if the timebox shows like the format.
		
		The timebox means the textbox below the Calendar , 
		check the value in timebox.
		
					
	</h:pre>
	
	<zscript>
		import java.util.Date;
		
		Date d = new Date(110,3,27,18,20,30);
	</zscript>
	<grid>
		<rows>
			<row>
				<label value="yyyy-MM-dd ss => should show 30 " />
				<datebox format="yyyy-MM-dd ss" value="${d}" width="300px" />
			</row>
			
			<row>
				<label value="yyyy-MM-dd hh:mm:ss => should show 06:20:30 " />
				<datebox format="yyyy-MM-dd hh:mm:ss" value="${d}" width="300px" />
			</row>
	
			<row>
				<label value="yyyy-MM-dd KK:mm:ss => should show 06:20:30 " />
				<datebox format="yyyy-MM-dd KK:mm:ss" value="${d}" width="300px" />
			</row>
			
			<row>
				<label value="yyyy-MM-dd hh:mm:ss aa  => should show 06:20:30 PM" />
				<datebox format="yyyy-MM-dd hh:mm:ss aa" value="${d}" width="300px" />
			</row>
			<row>
				<label value="yyyy-MM-dd aa hh:mm:ss  => should show PM 06:20:30 " />
				<datebox format="yyyy-MM-dd aa hh:mm:ss" value="${d}" width="300px" />
			</row>
			
			<row>
				<label value="yyyy-MM-dd KK:mm:ss => should show 06:20:30 " />
				<datebox format="yyyy-MM-dd KK:mm:ss " value="${d}" width="300px" />
			</row>
	
			<row>
				<label value="yyyy-MM-dd HH:mm:ss => should show 18:20:30 " />
				<datebox format="yyyy-MM-dd HH:mm:ss" value="${d}" width="300px" />
			</row>		
	
			<row>
				<label value="yyyy-MM-dd kk:mm:ss => should show 18:20:30 " />
				<datebox format="yyyy-MM-dd kk:mm:ss" value="${d}" width="300px" />
			</row>		
		
		</rows>
	</grid>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(jq("@datebox:eq(0)").toWidget().$n("btn"))
      waitResponse()
      var time = jq("@timebox:visible").toWidget().$n("real")
      verifyEquals("30", jq(time).`val`())
      click(jq("@datebox:eq(0)").toWidget().$n("btn"))
      click(jq("@datebox:eq(1)").toWidget().$n("btn"))
      waitResponse()
      verifyEquals("06:20:30", jq(time).`val`())
      click(jq("@datebox:eq(1)").toWidget().$n("btn"))
      click(jq("@datebox:eq(2)").toWidget().$n("btn"))
      waitResponse()
      verifyEquals("06:20:30", jq(time).`val`())
      click(jq("@datebox:eq(2)").toWidget().$n("btn"))
      click(jq("@datebox:eq(3)").toWidget().$n("btn"))
      waitResponse()
      verifyEquals("06:20:30 PM", jq(time).`val`())
      click(jq("@datebox:eq(3)").toWidget().$n("btn"))
      click(jq("@datebox:eq(4)").toWidget().$n("btn"))
      waitResponse()
      verifyEquals("PM 06:20:30", jq(time).`val`())
      click(jq("@datebox:eq(4)").toWidget().$n("btn"))
      click(jq("@datebox:eq(5)").toWidget().$n("btn"))
      waitResponse()
      verifyEquals("06:20:30", jq(time).`val`())
      click(jq("@datebox:eq(5)").toWidget().$n("btn"))
      click(jq("@datebox:eq(6)").toWidget().$n("btn"))
      waitResponse()
      verifyEquals("18:20:30", jq(time).`val`())
      click(jq("@datebox:eq(6)").toWidget().$n("btn"))
      click(jq("@datebox:eq(7)").toWidget().$n("btn"))
      waitResponse()
      verifyEquals("18:20:30", jq(time).`val`())
      click(jq("@datebox:eq(7)").toWidget().$n("btn"))
    })
  }
}



