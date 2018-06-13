/* B30_1737660Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget

class B30_1737660Test extends ZTL4ScalaTestCase {
  @Test
  def testlistboxwidth() = {
    var zscript =
      """
			  
			<?page title="ZKD Debug Page"
			style="height:100%;width:100%;margin:0;padding:0;"?>  
			<zk>
			The header cells' size should rendered correctly.
			i.e., the width of -hdfaker ( upper line of header ) should be zero
			if the header is hided 
			
			its incorrect on opera, correct on chrome, firefox, ie8, safari5
				<window id="winTest"
										top="15px"
										left="15px"
										height="400px"
										width="700px"
										sizable="false"
										title="Test Harness"
										closable="false"
										mode="overlapped"
										border="normal"
										style="overflow:hidden;">
			
					<zscript><![CDATA[
			
						// Loop for two boxes
						for (int z=0; z<2; z++) {
							// Draw the listbox
							Listbox lb = new Listbox();
							lb.setHeight("160px");
							lb.setParent(winTest);
							lb.setSizedByContent(true);
							Listhead lhs = new Listhead();
							lhs.setParent(lb);
							// Draw the headings
							for (x=1; x<8; x++) {
								String title = new String("12345678901234567890").substring(0, x*2);
								Listheader lh = new Listheader();
								lh.setLabel(title);
								lh.setParent(lhs);
							}
							// Add some items
							for (y=0; y<5; y++) {
								Listitem li = new Listitem();
								for (x=1; x<8; x++) {
									String title = new String("12345678901234567890").substring(0,x*2);
									Listcell lc = new Listcell();
									lc.setLabel(title);
									lc.setParent(li);
								}
								// Hide a few rows on the second pass to show the bug
								if (y < (z*2+1))
									li.setVisible(false);
								li.setParent(lb);
							}
						}
						
					]]></zscript>
										
				</window>
				
			</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val winTest = ztl$engine.$f("winTest")
    runZTL(zscript, () => {
      for (i <- 0 until 2) { // 2 listbox
        var jqlb = jq("@listbox").eq(i)
        var lhr = jqlb.find("@listhead").find("@listheader")
        var lc = jqlb.find("@listitem").find("@listcell")
        for (j <- 0 to 7) { // 7 listhead/listcell
          verifyEquals(lhr.eq(i).outerWidth(), lc.eq(i).outerWidth())
        }
      }
    })
  }
}



