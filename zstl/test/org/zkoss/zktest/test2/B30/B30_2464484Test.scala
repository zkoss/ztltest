/* B30_2464484Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_2464484Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<window title="RadiogroupSelectdItemConverter" width="500px" border="normal">
			<html>
			<![CDATA[
			<ol>
			<li>Shall see two radio 'Starts with' and 'Contains'</li>
			<ll>The 'Contains' radio shall be selected</ll>
			<li>Press 'show select' button, you shall see pop up 'C'</li>
			<li>Select 'Starts with'</li>
			<li>Then press 'show select' button, you shall see pop up 'S'</li>
			<li>Done.</li> 
			</ol>
			]]>
			</html>
			<zscript>
			<![CDATA[
			   class Select {
				   private String desc;
				   
				   public Select(String x) {
					   setDesc(x);
				   }
				   
				   public String getDesc() {
					   return desc;
				   }
				   public void setDesc(String desc) {
					   this.desc = desc;
				   }
			   }
			   Select select = new Select("C");
			]]>
			</zscript>
			<radiogroup selectedItem="@{select.desc}">
			   <grid>
			       <columns>
			           <column label="Selection"/>
			       </columns>
			       <rows>
			           <row spans="3">
			               <radio id="r1" label="Starts with" value="S" selected="true"/>
			           </row>
			           <row>
			               <radio id="r2" label="Contains" value="C" />
			           </row>
			       </rows>
			   </grid>
			</radiogroup>
			<button id="btn" label="show select" onClick='alert(""+select.getDesc())'/>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val r1 = ztl$engine.$f("r1")
    val r2 = ztl$engine.$f("r2")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      click(btn);
      waitResponse()
      verifyEquals("C", jq(".z-messagebox > span.z-label:eq(0)").text())
      click(jq("@button.z-button:eq(1)"));
      waitResponse()
      click(r1.$n("real"));
      waitResponse()
      click(btn);
      waitResponse()
      verifyEquals("S", jq(".z-messagebox > span.z-label:eq(0)").text())
    })
  }
}



