/* B85_ZK_3921Test.java

        Purpose:
        
        Description:
        
        History:
                Tue Jun 12 15:51:19 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.JQuery

class B85_ZK_3921Test extends ZTL4ScalaTestCase {
	
	@Test
	def test()=  {
		runZTL(() => {
			testWidget(jq(".z-grid-body"), jq(".z-button:eq(0)"))
			testWidget(jq(".z-listbox-body"), jq(".z-button:eq(2)"))
			testWidget(jq(".z-tree-body"), jq(".z-button:eq(4)"))
		})
	}
	
	def testWidget(widget: JQuery, button: JQuery)=  {
		verScroll(widget, 50)
		waitResponse()
		
		var scrollTop = widget.scrollTop()
		
		click(button)
		waitResponse()
		
		verifyEquals(scrollTop, widget.scrollTop())
		
		verScroll(widget, 100)
		waitResponse()
		
		scrollTop = widget.scrollTop()
		
		click(button.next())
		waitResponse()
		
		verifyEquals(scrollTop, widget.scrollTop())
	}
}
