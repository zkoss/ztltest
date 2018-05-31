/* B36_2900977Test.java

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
import org.zkoss.ztl.Widget


class B36_2900977Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			



<zk>


<zscript>
<![CDATA[


void addrow(){
Groupbox gr2=new Groupbox();
Caption c2=new Caption("Group 2");
Label ll2=new Label("move the in ie8 broken slider.");
Slider sl1=new Slider();
gr2.appendChild(ll2);
gr2.appendChild(sl1);
Vbox vbox=new Vbox();
vbox.appendChild(gr2);
Detail detail=new Detail();
detail.appendChild(vbox);
detail.setOpen(true);
Label label=new Label("myLabel");
Row row = new Row();
row.appendChild(label);
row.appendChild(detail);
rows.appendChild(row);

}
]]>
</zscript>

<grid id="grid1" width="300px" height="400px" >
<columns>
<column width="25px" />
<column label="Attribut"/>
<column width="25px" label="Status"/>
</columns>
<rows id="rows">

</rows>
</grid>
<button label="Click Me twice, you should not see any error." onClick="addrow()" />


</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val grid1 = ztl$engine.$f("grid1")
    val rows = ztl$engine.$f("rows")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}



