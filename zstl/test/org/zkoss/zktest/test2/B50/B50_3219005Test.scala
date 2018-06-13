/* B50_3219005Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3219005Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
Please click the "delete item5" and the last one should be "item 11" not "item 12".(ZK CE and PE version only)
<zscript>
<![CDATA[
import java.util.*;

List datas = new ArrayList();
for(int i=1;i<=15;i++){
datas.add("item "+i);
}
ListModel model = new ListModelList(datas,true);
]]>
</zscript>
<grid model="${model}" mold="paging" pageSize="10"/>
<button label="delete item5">
<attribute name="onClick">
<![CDATA[
Collection m = (Collection)model;
m.remove(model.getElementAt(5));
]]>
</attribute>
</button>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyEquals("item 11", jq("@row:last").text())
    })
  }
}



