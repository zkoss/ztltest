package org.zkoss.zktest.test2.B50

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B50-ZK-867.zul")
class B50_ZK_867Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<style>
		tr.myodd td.z-row-inner, tr.myodd {
			background-color: #E4EBF8;
		}
		.myimg {
			margin: 5px; border: 1px solid #CFCFCF;
		}
		div.z-column-content {
			text-align: center; font-weight: bold;
		}
		div.z-row-content span {
			font-family: Tahoma,Arial,serif;
			color: #0E3A99;
		}
		.heavy {
			font-weight:bold;
		}
		tr.z-grid-odd td.z-row-inner, tr.z-grid-odd {
			background-color: #E4F8EB;
		}
	</style>
	<div>Open the second detail of both grid below,</div>
	<div>if the style of the content of second detail is different with first detail, it is correct.</div>
	<grid oddRowSclass="myodd" height="300px" width="600px">
		<columns>
			<column width="40px" />
			<column sort="auto" />
			<column width="100px" label="Price" sort="auto" />
			<column label="Item location" sort="auto" />
		</columns>
		<rows>
			<row>
				<detail open="true">
					<hlayout>
						<image sclass="myimg" width="100px" height="100px"
							src="/widgets/grid/master_detail/img/item1.jpg" />
						<vlayout>
							<label value="Item Specifics - Item Condition"
								style="font-weight:bold;font-style: italic;" />
							<hlayout>
								<label value="Condition:" />
								<label value="Used" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Brand:" />
								<label value="Apple" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Technology:" />
								<label value="DVI" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Monitor Type:" />
								<label value="LCD/Flat Panel" sclass="heavy" />
							</hlayout>
						</vlayout>
					</hlayout>
				</detail>
				<label value="Apple 20-inch Aluminum Cinema Display M9177/A" />
				<label style="color:green;float:right;" value="US $202.50" />
				<label value="Tulsa, OK, United States" />
			</row>
			<row>
				<detail fulfill="onOpen">
					<hlayout>
						<image sclass="myimg" width="100px" height="100px"
							src="/widgets/grid/master_detail/img/item2.jpg" />
						<vlayout>
							<label value="Item Specifics"
								style="font-weight:bold;font-style: italic;" />
							<hlayout>
								<label value="Condition:" />
								<label value="Used" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Brand:" />
								<label value="Kyocera" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Phone Type:" />
								<label value="Phones without Service Contrac" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Product Type:" />
								<label value="Cell Phones" sclass="heavy" />
							</hlayout>
						</vlayout>
					</hlayout>
				</detail>
				<label value="Kyocera Strobe K612B MetroPCS Metro PCS Cell Phone L@@K" />
				<label style="color:green;float:right;" value="US $174.99" />
				<label value="Princeton, NJ, USA, United States" />
			</row>
			<row>
				<detail fulfill="onOpen">
					<hlayout>
						<image sclass="myimg" width="100px" height="100px"
							src="/widgets/grid/master_detail/img/item3.jpg" />
						<vlayout>
							<label value="Item Specifics - Video Game Systems"
								style="font-weight:bold;font-style: italic;" />
							<hlayout>
								<label value="Manufacturer:" />
								<label value="Microsoft" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Platform:" />
								<label value="Microsoft Xbox 360" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="MPN:" />
								<label value="52T-00013" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Condition:" />
								<label value="Used" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Condition:" />
								<label value="Used" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Media Type:" />
								<label value="DVD-ROM" sclass="heavy" />
							</hlayout>
						</vlayout>
					</hlayout>
				</detail>
				<label value="Halo 3 ed. xbox 360 bundle pack" />
				<label style="color:green;float:right;" value="US $350.00" />
				<label value="Middletown, PA, United States" />
			</row>	
			<row>
				<detail fulfill="onOpen">
					<hlayout>
						<image sclass="myimg" width="100px" height="100px"
							src="/widgets/grid/master_detail/img/item4.jpg" />
						<vlayout>
							<label
								value="Item Specifics - Cell Phones &amp; Smartphones"
								style="font-weight:bold;font-style: italic;" />
							<hlayout>
								<label value="Carrier:" />
								<label value="AT&amp;T, Cingular" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Brand:" />
								<label value="Apple iPhone" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Technology:" />
								<label value="GSM" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Camera:" />
								<label value="1-2 Megapixels" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Condition:" />
								<label value="Used" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Features:" />
								<label sclass="heavy" 
									value="Bluetooth Enabled, Calendar, Color Screen, Email Access, GPS, Internet Browser, MP3 Player, PDA-PC Sync, SMS-Text Messaging, Speakerphone, Touch Screen, USB Interface" />
							</hlayout>
						</vlayout>
					</hlayout>
				</detail>
				<label value="Apple iPhone 8GB - 1st Generation, Version 2.0" />
				<label style="color:green;float:right;" value="US $300.00" />
				<label value="Aspen, CO, United States" />
			</row>
		</rows>
	</grid>
	<grid height="300px" width="600px">
		<columns>
			<column width="40px" />
			<column sort="auto" />
			<column width="100px" label="Price" sort="auto" />
			<column label="Item location" sort="auto" />
		</columns>
		<rows>
			<row>
				<detail open="true">
					<hlayout>
						<image sclass="myimg" width="100px" height="100px"
							src="/widgets/grid/master_detail/img/item1.jpg" />
						<vlayout>
							<label value="Item Specifics - Item Condition"
								style="font-weight:bold;font-style: italic;" />
							<hlayout>
								<label value="Condition:" />
								<label value="Used" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Brand:" />
								<label value="Apple" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Technology:" />
								<label value="DVI" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Monitor Type:" />
								<label value="LCD/Flat Panel" sclass="heavy" />
							</hlayout>
						</vlayout>
					</hlayout>
				</detail>
				<label value="Apple 20-inch Aluminum Cinema Display M9177/A" />
				<label style="color:green;float:right;" value="US $202.50" />
				<label value="Tulsa, OK, United States" />
			</row>
			<row>
				<detail fulfill="onOpen">
					<hlayout>
						<image sclass="myimg" width="100px" height="100px"
							src="/widgets/grid/master_detail/img/item2.jpg" />
						<vlayout>
							<label value="Item Specifics"
								style="font-weight:bold;font-style: italic;" />
							<hlayout>
								<label value="Condition:" />
								<label value="Used" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Brand:" />
								<label value="Kyocera" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Phone Type:" />
								<label value="Phones without Service Contrac" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Product Type:" />
								<label value="Cell Phones" sclass="heavy" />
							</hlayout>
						</vlayout>
					</hlayout>
				</detail>
				<label value="Kyocera Strobe K612B MetroPCS Metro PCS Cell Phone L@@K" />
				<label style="color:green;float:right;" value="US $174.99" />
				<label value="Princeton, NJ, USA, United States" />
			</row>
			<row>
				<detail fulfill="onOpen">
					<hlayout>
						<image sclass="myimg" width="100px" height="100px"
							src="/widgets/grid/master_detail/img/item3.jpg" />
						<vlayout>
							<label value="Item Specifics - Video Game Systems"
								style="font-weight:bold;font-style: italic;" />
							<hlayout>
								<label value="Manufacturer:" />
								<label value="Microsoft" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Platform:" />
								<label value="Microsoft Xbox 360" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="MPN:" />
								<label value="52T-00013" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Condition:" />
								<label value="Used" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Condition:" />
								<label value="Used" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Media Type:" />
								<label value="DVD-ROM" sclass="heavy" />
							</hlayout>
						</vlayout>
					</hlayout>
				</detail>
				<label value="Halo 3 ed. xbox 360 bundle pack" />
				<label style="color:green;float:right;" value="US $350.00" />
				<label value="Middletown, PA, United States" />
			</row>	
			<row>
				<detail fulfill="onOpen">
					<hlayout>
						<image sclass="myimg" width="100px" height="100px"
							src="/widgets/grid/master_detail/img/item4.jpg" />
						<vlayout>
							<label
								value="Item Specifics - Cell Phones &amp; Smartphones"
								style="font-weight:bold;font-style: italic;" />
							<hlayout>
								<label value="Carrier:" />
								<label value="AT&amp;T, Cingular" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Brand:" />
								<label value="Apple iPhone" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Technology:" />
								<label value="GSM" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Camera:" />
								<label value="1-2 Megapixels" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Condition:" />
								<label value="Used" sclass="heavy" />
							</hlayout>
							<hlayout>
								<label value="Features:" />
								<label sclass="heavy" 
									value="Bluetooth Enabled, Calendar, Color Screen, Email Access, GPS, Internet Browser, MP3 Player, PDA-PC Sync, SMS-Text Messaging, Speakerphone, Touch Screen, USB Interface" />
							</hlayout>
						</vlayout>
					</hlayout>
				</detail>
				<label value="Apple iPhone 8GB - 1st Generation, Version 2.0" />
				<label style="color:green;float:right;" value="US $300.00" />
				<label value="Aspen, CO, United States" />
			</row>
		</rows>
	</grid>
</zk>"""

    runZTL(zscript,
      () => {
        val product0 = jq(".z-grid:eq(0) .z-row:contains(Kyocera)")
        click(widget(product0.find("@detail")).$n("icon"))
        waitResponse()
        val detail0 = product0.next()
        
        val product1 = jq(".z-grid:eq(1) .z-row:contains(Kyocera)")
        click(widget(product1.find("@detail")).$n("icon"))
        waitResponse()
        val detail1 = product1.next()
        
        verifyNotEquals("the style of the content of second detail should be different with first detail", detail0.css("background-color"), detail1.css("background-color"))
      })

  }
}
