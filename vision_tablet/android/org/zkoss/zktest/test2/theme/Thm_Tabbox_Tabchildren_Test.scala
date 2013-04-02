package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Tabbox_Tabchildren_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<tabbox width="450px" mold="accordion">
		<tabs>
			<tab label="Tab 2" closable="true" image="/img/live.gif">
				<caption label="search" image="/img/live.gif">
					<combobox>
						<comboitem label="item 1" />
						<comboitem label="item 2" />
						<comboitem label="item 3" />
						<comboitem label="item 4" />
					</combobox>
				</caption>
			</tab>
			<tab closable="true">
				<caption hflex="min" label="search" image="/img/live.gif">
					<textbox />
					<combobox>
						<comboitem label="item 1" />
						<comboitem label="item 2" />
						<comboitem label="item 3" />
						<comboitem label="item 4" />
					</combobox>
				</caption>
			</tab>
			<tab closable="true" label="Tab3" />
		</tabs>
		<toolbar width="90px">
			<toolbarbutton image="/img/live.gif" onClick='alert("Live")' />
			<toolbarbutton image="/img/defender.gif" onClick='alert("Defender")' />
			<toolbarbutton image="/img/battery.gif" onClick='alert("Battery")' />
		</toolbar>
		<tabpanels>
			<tabpanel>This is panel 1</tabpanel>
			<tabpanel>This is panel 2
				The second panel</tabpanel>
			<tabpanel>This is panel 3</tabpanel>
			<tabpanel>This is panel 4</tabpanel>
			<tabpanel>This is panel 5</tabpanel>
		</tabpanels>
	</tabbox>
	<separator />
	<tabbox width="450px">
		<tabs>
			<tab height="28px" label="Tab 1" closable="true" />
			<tab height="28px" label="Tab 2" closable="true" image="/img/live.gif">
				<caption label="search" hflex="min" image="/img/live.gif">
					<custom-attributes org.zkoss.zul.image.preload="true" />
				</caption>
			</tab>
			<tab height="28px" closable="true">
				<caption hflex="min" label="search">
					<textbox />
				</caption>
			</tab>
			<tab height="28px" label="Tab 4" closable="true">
				<caption hflex="min" label="search">
					<combobox>
						<comboitem label="item 1" />
						<comboitem label="item 2" />
						<comboitem label="item 3" />
						<comboitem label="item 4" />
					</combobox>
				</caption>
			</tab>
			<tab height="28px" label="Tab 5" closable="true" />
		</tabs>
		<toolbar width="90px">
			<toolbarbutton image="/img/live.gif" onClick='alert("Live")' />
			<toolbarbutton image="/img/defender.gif" onClick='alert("Defender")' />
			<toolbarbutton image="/img/battery.gif" onClick='alert("Battery")' />
		</toolbar>
		<tabpanels>
			<tabpanel>This is panel 1</tabpanel>
			<tabpanel>This is panel 2
				The second panel</tabpanel>
			<tabpanel>This is panel 3</tabpanel>
			<tabpanel>This is panel 4</tabpanel>
			<tabpanel>This is panel 5</tabpanel>
		</tabpanels>
	</tabbox>
	<separator />
	<vbox>
		<tabbox id="tb" width="500px" mold="accordion">
			<tabs>
				<tab height="60px" label="Tab 1" />
				<tab label="Tab 2" />
			</tabs>
			<tabpanels>
				<tabpanel>
					<tabbox id="tb2" orient="vertical">
						<tabs width="250px">
							<tab label="Tab 2" closable="true" image="/img/live.gif">
								<caption hflex="min" label="search" image="/img/live.gif">
									<textbox />
								</caption>
							</tab>
							<tab closable="true">
								<caption hflex="min" label="search" image="/img/live.gif">
									<textbox />
								</caption>
							</tab>
							<tab>
								<caption hflex="min" label="search" image="/img/live.gif">
									<textbox />
								</caption>
							</tab>
							<tab label="D" closable="true" />
							<tab label="D" />
							<tab label="E" />
						</tabs>
						<tabpanels>
							<tabpanel>This is panel A</tabpanel>
							<tabpanel>This is panel B</tabpanel>
							<tabpanel>This is panel C</tabpanel>
							<tabpanel>This is panel D</tabpanel>
							<tabpanel>This is panel E</tabpanel>
						</tabpanels>
					</tabbox>
				</tabpanel>
				<tabpanel>
					This is panel 2
					The second panel
				</tabpanel>
			</tabpanels>
		</tabbox>
		<checkbox label="Use light mold"
			onCheck='tb.mold=self.checked?"accordion-lite":"accordion"' />
	</vbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				singleTap(jq("input[type=checkbox]"));
				waitResponse();
				verifyImage();
			});
	}
}