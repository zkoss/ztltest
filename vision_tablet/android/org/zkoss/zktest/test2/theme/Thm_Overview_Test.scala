package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Overview_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<?component name="hlayout" extends="hlayout" spacing="10px" ?>
<?component name="vlayout" extends="vlayout" spacing="10px" ?>
<zk>
	<zscript><![CDATA[
		import org.zkoss.zul.*;
		String[] strs = new String[20];
		for (int i = 0; i < 20; i++)
			strs[i] = "Item " + i;
		ListModel model = new SimpleListModel(strs);
		model.multiple = true;
	]]></zscript>
	<hlayout hflex="1" vflex="1">
		<window hflex="1" vflex="1" border="normal" title="Window" 
			closable="true" maximizable="true" minimizable="true">
			<vlayout hflex="1" vflex="1" style="padding: 10px">
				<hlayout hflex="1" vflex="1">
					<tabbox hflex="1" vflex="1">
						<tabs>
							<tab forEach="1,2,3">Tab ${each}</tab>
						</tabs>
						<tabpanels>
							<tabpanel forEach="1,2,3">
								Tabpanel ${each}
							</tabpanel>
						</tabpanels>
					</tabbox>
					<tabbox hflex="1" vflex="1" mold="accordion">
						<tabs>
							<tab forEach="1,2,3">Tab ${each}</tab>
						</tabs>
						<tabpanels>
							<tabpanel forEach="1,2,3">
								Tabpanel ${each}
							</tabpanel>
						</tabpanels>
					</tabbox>
					<groupbox mold="3d" hflex="1" vflex="1">
						<caption label="Groupbox" />
					</groupbox>
				</hlayout>
				<hlayout hflex="1" vflex="1">
					<grid model="${model}" hflex="1" vflex="1" 
						mold="paging" pageSize="10">
						<auxhead>
							<auxheader label="Auxheader" colspan="2" />
						</auxhead>
						<columns>
							<column label="Header 1" sort="auto" />
							<column label="Header 2" sort="auto" />
						</columns>
						<foot>
							<footer span="2">Footer</footer>
						</foot>
					</grid>
					<listbox model="${model}" hflex="1" vflex="1" 
						mold="paging" pageSize="10" checkmark="true">
						<auxhead>
							<auxheader label="Auxheader" colspan="2" />
						</auxhead>
						<listhead>
							<listheader label="Header 1" sort="auto" />
							<listheader label="Header 2" sort="auto" />
						</listhead>
						<listfoot>
							<listfooter span="2">Listfooter</listfooter>
						</listfoot>
					</listbox>
					<tree model="${tmodel}" hflex="1" vflex="1"
						mold="paging" pageSize="10" checkmark="true">
						<auxhead>
							<auxheader label="Auxheader" colspan="2" />
						</auxhead>
						<treecols>
							<treecol label="Header 1" sort="auto" />
							<treecol label="Header 2" sort="auto" />
						</treecols>
					</tree>
				</hlayout>
			</vlayout>
		</window>
		<separator orient="vertical" />
		<panel hflex="1" vflex="1" border="normal" title="Panel" framable="true"
			closable="true" maximizable="true" minimizable="true" collapsible="true">
			<panelchildren>
				<menubar>
					<menu label="Menu">
						<menupopup>
							<menuitem label="Menuitem" />
							<menuseparator />
							<menuitem label="Menuitem" image="/img/DisketteBlack-16x16.png" />
						</menupopup>
					</menu>
					<menuitem label="Menuitem" />
				</menubar>
				<borderlayout>
					<south title="South" size="30%" splittable="true" collapsible="true">
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris 
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in 
						reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla 
						pariatur. Excepteur sint occaecat cupidatat non proident, 
						sunt in culpa qui officia deserunt mollit anim id est laborum.
					</south>
					<west title="West" size="30%" splittable="true" collapsible="true">
						<vlayout hflex="1" style="padding: 10px">
							<doublebox hflex="1" />
							<datebox hflex="1" />
							<bandbox hflex="1" />
							<combobox hflex="1" />
							<timebox hflex="1" />
							<spinner hflex="1" />
							<doublespinner hflex="1" />
							<separator bar="true" />
							<div>
								<button label="Button" />
								<combobutton label="Combobutton" />
							</div>
						</vlayout>
					</west>
					<center>
						<hlayout hflex="1" vflex="1" style="padding: 10px">
							<groupbox title="Groupbox" hflex="1" vflex="1">
								MISC: progressmeter, slider, button for notif., popup, messagebox, loading
							</groupbox>
							<separator orient="vertical" bar="true" vflex="1" />
							<groupbox hflex="1" vflex="1">
								<caption label="Groupbox" />
							</groupbox>
						</hlayout>
					</center>
				</borderlayout>
				Panel Content
			</panelchildren>
			<toolbar mold="panel">
				<toolbarbutton label="Toolbarbutton" />
				<combobutton mold="toolbar" label="Combobutton" />
			</toolbar>
		</panel>
	</hlayout>
</zk>
""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}