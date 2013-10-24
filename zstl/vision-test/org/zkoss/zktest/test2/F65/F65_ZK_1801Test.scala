package org.zkoss.zktest.test2.F65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import org.junit.Test
import org.zkoss.ztl.Tags

@Tags(tags = "F65-ZK-1801.zul")
class F65_ZK_1801Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<vlayout apply="org.zkoss.bind.BindComposer"
		viewModel="@id('vm')@init('org.zkoss.zktest.test2.F65_ZK_1801_ViewModel')"
		validationMessages="@id('vmsgs')">
		The Funnel Chart will appear, with 4 sections, the configuration widgets, 
		should update the chart's appearance
		<fusionchart id="mychart" title="Fusion Pie Chart Demo" width="550"
			height="400" type="funnel" model="@load(vm.model)" chartConfig="@bind(vm.chartConfig)"
			onClick="@command('showMessage',data=event.data)" />
	    <hlayout  visible="@bind(not empty vm.message)">
	        You clicked on :<label value="@bind(vm.message)"/>
	    </hlayout>
	
		<grid>
			<rows>
				<row>
				    custom colors
				    <button label="apply" onClick="@command('applyCustomColors')" />
				</row>
				<row>
					sliced
					<checkbox checked="@bind(vm.sliced)" onCheck="@command('configUpdated')"></checkbox>
				</row>
				<row>
				    show values
				    <checkbox checked="@bind(vm.showValues)" onCheck="@command('configUpdated')"></checkbox>
				</row>
				<row>
				    decimal precision		
				    <intbox value="@bind(vm.decimalPrecision)" onChange="@command('configUpdated')"></intbox>
				</row>
			</rows>
		</grid>    
	</vlayout>
</zk>"""  
  runZTL(zscript,
    () => {
      sleep(6000)
      verifyImage()
      click(jq(".z-button"))
      waitResponse()
      sleep(6000)
      verifyImage()
      click(jq(".z-checkbox").eq(0).toWidget().$n("real"))
      waitResponse()
      sleep(6000)
      verifyImage()
      click(jq(".z-checkbox").eq(1).toWidget().$n("real"))
      waitResponse()
      sleep(6000)
      verifyImage()
      
    })
    
  }
}