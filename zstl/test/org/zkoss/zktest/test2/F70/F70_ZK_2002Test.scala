package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-2002.zul")
class F70_ZK_2002Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      val tb = jq(".z-tabbox").eq(3)
      0 to 2 foreach { index =>
      	click(tb.find(".z-tab:eq(" + index + ")"))
      	waitResponse()
      	
      	verifyTrue("each tabpanel should start with a 'New --' text", tb.find(".z-tabpanel:eq(" + index + "):contains(New --)").exists)
      }
      
      click(jq(".z-button:contains(add New Tab)"))
      waitResponse()
      verifyTrue("should see one 'New -- tab4' tab is added.", tb.find(".z-tab:contains(New -- Tab4)").exists)
      
      click(jq(".z-button:contains(remove First Tab)"))
      waitResponse()
      verifyTrue("should see one 'New -- tab1' tab is removed.", !tb.find(".z-tab:contains(New -- Tab1)").exists)
      
      click(jq(".z-button:contains(change model)"))
      waitResponse()
      verifyTrue("should see only two tabs with 'New -- Model'.", tb.find(".z-tab:contains(New -- Model)").length() == 2)
      
      click(jq(".z-button").eq(6))
      waitResponse()
      verifyTrue("should see the 'New -- Model 2' is selected.", tb.find(".z-tab-selected:contains(New -- Model 2)").exists())
      
      click(tb.find(".z-tab:eq(0)"))
      waitResponse()
      click(jq(".z-button").eq(7))
      waitResponse()
      verifyTrue("should see the message is '[Model 1]'", jq(".z-window").find(".z-label:contains([Model 1])").exists())
      
    })
    
  }
}