package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2096.zul")
class B70_ZK_2096Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<div>
		Click button then the z-treecols-bar should not be in front of treecol, 
		please try to click in many times and the tree should not flicker
	</div>
	<div style="height:200px" apply="org.zkoss.bind.BindComposer"
		viewModel="@id('vm') @init('org.zkoss.zktest.test2.B70_ZK_2096_ViewModel')">
		<tree model="@load(vm.treeModel)" id="tree" width="30%"
			vflex="1" rows="8">
			<custom-attributes org.zkoss.zul.nativebar="true" />
			<treecols sizable="false" children="@load(vm.cols)">
				<template name="children" var="node">
					<treecol label="@load(node)" width="80px"
						visible="@load(vm.isVisible(node))" />
				</template>
			</treecols>

			<template name="model" var="row">
				<treeitem>
					<treerow children="@load(vm.items)">
						<template name="children" var="node">
							<treecell>
								<label value="@load(node)" />
							</treecell>
						</template>
					</treerow>
				</treeitem>
			</template>
		</tree>

		<button label="do something" onClick="@command('doSomething')" />
	</div>

</zk>"""  
  runZTL(zscript,
    () => {
      val btn = jq(".z-button")
      
      1 to 5 foreach { n =>
      	click(btn)
      	waitResponse()
      }
      
      verifyTrue("the z-treecols-bar should not be in front of treecol", !jq("[id$=hdfaker-bar] + [id$=hdfaker]").exists)
    })
    
  }
}