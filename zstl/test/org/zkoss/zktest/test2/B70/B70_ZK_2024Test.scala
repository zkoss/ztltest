package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import org.openqa.selenium.Keys

@Tags(tags = "B70-ZK-2024.zul")
class B70_ZK_2024Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<div>
		type 'se' + 'TAB' in the combobox then the label should show 'Sverige' and the value should show 'SE'.
	</div>
	<hbox apply="org.zkoss.bind.BindComposer"
		viewModel="@id('vm') @init('org.zkoss.zktest.test2.B70_ZK_2024_ViewModel')">
		<combobox model="@init(vm.countries)"
			selectedItem="@bind(vm.country)" autodrop="true"
			autocomplete="true">
			<template name="model">
				<comboitem value="${each.code}" label="${each.code}"
					description="${each.name}" />
			</template>
		</combobox>
		<cell width="8em" valign="middle">
			<label value="@load(vm.country.name)" />
		</cell>
		<textbox />
	</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      val inp = jq(".z-combobox").toWidget().$n("real")
      sendKeys(inp, "se" + Keys.TAB)
      waitResponse()
      
      verifyTrue("the label should show 'Sverige' and the value should show 'SE'.", 
          inp.get("value") == "SE" && jq(".z-label:contains(Sverige)").exists)
    })
    
  }
}