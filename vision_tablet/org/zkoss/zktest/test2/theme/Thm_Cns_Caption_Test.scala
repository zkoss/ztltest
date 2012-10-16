package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Cns_Caption_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<style>
		.block {
			width: 200px;
			height: 200px;
			padding: 5px;
		}
	</style>
	<hlayout>
		<div sclass="block">
			<borderlayout hflex="1" vflex="1">
				<north title="North" size="30%">
					North Content
				</north>
				<center>
					Center Content
				</center>
				<west title="West" size="30%">
					West Content
				</west>
			</borderlayout>
		</div>
		<div sclass="block">
			<tabbox vflex="1">
				<tabs>
					<tab label="Tab ${each}" forEach="1,2" />
				</tabs>
				<tabpanels>
					<tabpanel forEach="1,2">
						Tabpanel Content
					</tabpanel>
				</tabpanels>
			</tabbox>
		</div>
		<div sclass="block">
			<tabbox mold="accordion" vflex="1">
				<tabs>
					<tab label="Tab ${each}" forEach="1,2" />
				</tabs>
				<tabpanels>
					<tabpanel forEach="1,2">
						Tabpanel Content
					</tabpanel>
				</tabpanels>
			</tabbox>
		</div>
		<div sclass="block">
			<groupbox mold="3d" title="Groupbox" vflex="1">
				Groupbox Content
			</groupbox>
		</div>
	</hlayout>
	<separator />
	<hlayout>
		<div sclass="block">
			<grid vflex="1">
				<auxhead>
					<auxheader colspan="2" label="Grid - Auxheader" />
				</auxhead>
				<columns>
					<column label="Col ${each}" forEach="1,2" />
				</columns>
				<rows>
					<group label="Group" />
					<row>
						<div forEach="1,2">Cell ${each}</div>
					</row>
					<groupfoot label="Groupfoot" spans="2" />
				</rows>
				<foot>
					<footer span="2">Footer</footer>
				</foot>
			</grid>
		</div>
		<div sclass="block">
			<listbox vflex="1">
				<auxhead>
					<auxheader colspan="2" label="Listbox - Auxheader" />
				</auxhead>
				<listhead>
					<listheader label="Header ${each}" forEach="1,2" />
				</listhead>
				<listgroup label="Listgroup" />
				<listitem>
					<listcell forEach="1,2">Cell ${each}</listcell>
				</listitem>
				<listgroupfoot label="Listgroupfoot" />
				<listfoot>
					<listfooter span="2">Listfooter</listfooter>
				</listfoot>
			</listbox>
		</div>
		<div sclass="block">
			<tree vflex="1">
				<auxhead>
					<auxheader colspan="2" label="Tree - Auxheader" />
				</auxhead>
				<treecols>
					<treecol label="Header ${each}" forEach="1,2" />
				</treecols>
				<treechildren>
					<treeitem>
						<treerow>
							<treecell forEach="1,2">Cell ${each}</treecell>
						</treerow>
					</treeitem>
				</treechildren>
				<treefoot>
					<treefooter span="2">Treefooter</treefooter>
				</treefoot>
			</tree>
		</div>
	</hlayout>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}