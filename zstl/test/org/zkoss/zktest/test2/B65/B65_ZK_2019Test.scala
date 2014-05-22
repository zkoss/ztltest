package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2019.zul")
class B65_ZK_2019Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window title="Chosenbox with comparator in ListSubModel" border="normal" width="400px" height="150px" 
apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.test2.B65_ZK_2019')">
	<vlayout apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.test2.B65_ZK_2019')">
		<label multiline="true">
			1. Enter "oh".
			2. Your will see "John (john@company.org)" option.
		</label>
		<separator/>
		<chosenbox  model="@load(vm.model)" hflex="1"/>
	</vlayout>
</window>
"""  
  runZTL(zscript,
    () => {
      var cb = jq(".z-chosenbox").toWidget()
      sendKeys(cb.$n("inp"), "oh")
      waitResponse(true)
      verifyTrue("Your will see 'John (john@company.org)' option.", jq(".z-chosenbox-option:contains(john@company.org)").exists)
    })
    
  }
}