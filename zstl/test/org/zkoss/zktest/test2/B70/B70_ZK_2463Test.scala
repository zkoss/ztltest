package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2463.zul")
class B70_ZK_2463Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk>
	<label multiline="true">
	1. click button 'add new Col'
	2. you should scroll right and will see new column (without javascript error)
	</label>

	<window apply="org.zkoss.bind.BindComposer"
		title="frozen grid and dynamic columns adding"
		viewModel="@id('vm') @init('org.zkoss.zktest.test2.B70_ZK_2463_GridViewModel')" width="1024px"
		height="576px">
		<vlayout vflex="1">
			<grid model="@load(vm.rows)" vflex="1">
				<frozen columns="1" />
				<auxhead children="@load(vm.heads)">
					<template name="children" var="h">
						<auxheader label="${h.title}"
							colspan="${h.colspan}" align="center" />
					</template>
				</auxhead>
				<columns children="@load(vm.columns)">
					<template name="children" var="c">
						<column label="${c.title}" width="192px"
							align="center" />
					</template>
				</columns>
				<template name="model" var="r">
					<row children="@load(r.values)">
						<template name="children" var="v">
							<label value="${v}" />
						</template>
					</row>
				</template>
			</grid>
			<hbox hflex="1">
				<cell hflex="1" align="right">
					<button label="add new Col"
						onClick="@command('doAdd')" />
				</cell>
			</hbox>
		</vlayout>
	</window>
</zk>

"""  
  runZTL(zscript,
    () => {
      
      var addBtn = jq(".z-button:contains(add)");
      var scrollBar = jq(".z-frozen").toWidget().$n("scrollX");
      var startL = jq(scrollBar).positionLeft();
      var startT = jq(scrollBar).positionTop();
      var endL = startL + 500;
      
      click(addBtn);
      waitResponse();
      verifyTrue(jq(".z-column-content:contains(col 9)").length() > 0);
        
    })
    
  }
}