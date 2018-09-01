/* B36_2821745Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2821745Test extends ZTL4ScalaTestCase {
  @Test
  def testopen() = {
    var zscript =
      """
		<zk>
		    <zscript>
		        String[] data = new String[10];
				for(int j=0; j &lt; data.length; ++j) {
					data[j] = "option "+j;
				}
				ListModel strset = new SimpleListModel(data);
			
		    </zscript>
		    <listbox id="list" width="200px" rows="10" onSelect='gb.open = true;' model="&#36;{strset}"></listbox>
		    <groupbox id="gb" mold="3d" width="400px">
		        <caption label="Quickly press on the Close Me button, and then select one item, the groupbox should open again!"/>
		        <button label="Close Me" onClick="gb.open = false"/>
		    </groupbox>
		</zk>
		 """
    val ztl$engine = engine()
    val list = ztl$engine.$f("list")
    val gb = ztl$engine.$f("gb")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      click(jq("@listcell:contains(option 5)"))
      waitResponse()
      verifyEquals("block", jq("@groupbox").find(".z-groupbox-content").css("display"))
    })
  }
}



