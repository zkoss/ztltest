/* B50_3057311Test.java

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


class B50_3057311Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
1. Please select "ActionMovies" on the drop down list.
  <listbox id='categoryLstBox' mold="select" rows="1">
  		<attribute name="onSelect">
  		Messagebox.show("Press on either Yes or No is okay, and then focus into the listbox, you shouldn't see the dialog again!",
                      "Confirmation Prompt",
                      Messagebox.YES | Messagebox.NO,
                      Messagebox.QUESTION,
                      new org.zkoss.zk.ui.event.EventListener() {
                        public void onEvent(Event evt) throws Exception{
                         categoryLstBox.selectedIndex = 0;
                        }//end onEvent()
                      }//end EventListener instance
                      );
      
  		</attribute>
     <listitem label='Cartoons' value='C' selected='true'/>
     <listitem label='ActionMovies' value='A' />
  </listbox>
  <textbox focus="true"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val categoryLstBox = ztl$engine.$f("categoryLstBox")
    runZTL(zscript, () => {
      select(categoryLstBox, "ActionMovies")
      waitResponse()
      click(jq(".z-window-highlighted @button:eq(0)"))
      waitResponse()
      focus(jq("@textbox"))
      verifyFalse(jq(".z-window-highlighted @button:eq(0)").exists())
    })
  }
}



