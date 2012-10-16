package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Cns_Mesh_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<zscript><![CDATA[
		import org.zkoss.zul.*;
		// list model
		String[] strs = new String[26];
		for (int i = 0; i < 26; i++)
			strs[i] = "" + (char) ('A' + i);
		ListModelList model1 = new ListModelList(strs);
		model1.setMultiple(true);
		
		// tree model
		final DefaultTreeNode[] n1 = new DefaultTreeNode[5];
		for (int i = 0; i < 5; i++) {
			DefaultTreeNode[] n2 = new DefaultTreeNode[4];
			for (int j = 0; j < 4; j++)
				n2[j] = new DefaultTreeNode("" + (char) ('A' + 2 + i * 5 + j));
			n1[i] = new DefaultTreeNode("" + (char) ('A' + 1 + i * 5), n2);
		}
		DefaultTreeModel model2 = new DefaultTreeModel(new DefaultTreeNode("A", n1));
		model2.setMultiple(true);
		model2.setOpenObjects(java.util.Arrays.asList(n1));
		
		// groups model
		String[][] data = new String[5][5];
		String[] heads = new String[5];
		String[] foots = new String[5];
		for (int i = 0; i < 5; i++) {
			heads[i] = "Group " + i;
			foots[i] = "Foot " + i;
			for (int j = 0; j < 5; j++)
				data[i][j] = "" + (char) ('A' + i * 5 + j);
		}
		SimpleGroupsModel model3 = new SimpleGroupsModel(data, heads, foots); 
		
	]]></zscript>
	<hlayout vflex="1">
		<div hflex="1">
			<grid model="${model3}" height="300px">
				<columns>
					<column label="Grid" />
				</columns>
				<foot>
					<footer label="Foot" />
				</foot>
   			</grid>
   			<separator />
			<grid model="${model1}" mold="paging" pageSize="6">
				<auxhead>
					<auxheader label="Auxheader" colspan="2" />
				</auxhead>
				<columns menupopup="auto">
					<column label="Col 1" sort="auto" />
					<column label="Col 2" sort="auto" />
				</columns>
				<template name="model">
					<row>
						<label>${each}</label>
						<label>Cell</label>
					</row>
				</template>
			</grid>
		</div>
		<div hflex="1">
			<listbox model="${model3}" height="300px">
				<listhead>
					<listheader label="Listbox" />
				</listhead>
				<listfoot>
					<listfooter label="Foot" />
				</listfoot>
			</listbox>
   			<separator />
			<listbox model="${model1}" checkmark="true" mold="paging" pageSize="6">
				<auxhead>
					<auxheader label="Auxheader" colspan="2" />
				</auxhead>
				<listhead>
					<listheader label="Col 1" sort="auto" />
					<listheader label="Col 2" sort="auto" />
				</listhead>
				<template name="model">
					<listitem>
						<listcell>${each}</listcell>
						<listcell>Cell</listcell>
					</listitem>
				</template>
			</listbox>
		</div>
		<div hflex="1">
			<tree model="${model2}" height="300px">
				<treecols>
					<treecol label="Tree" />
				</treecols>
				<treefoot>
					<treefooter label="Foot" />
				</treefoot>
			</tree>
   			<separator />
			<tree model="${model2}" checkmark="true" mold="paging" pageSize="6">
				<auxhead>
					<auxheader label="Auxheader" colspan="2" />
				</auxhead>
				<treecols>
					<treecol label="Col 1" sort="auto" />
					<treecol label="Col 2" sort="auto" />
				</treecols>
				<template name="model">
					<treeitem>
						<treerow>
							<treecell>${each}</treecell>
							<treecell>Cell</treecell>
						</treerow>
					</treeitem>
				</template>
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