package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Tree_2_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	Tree with CheckMark 
	<button label="Toggle checkmark" onClick="tree3.checkmark = !tree3.checkmark;"/>
	<button label="Toggle multiple" onClick="tree3.multiple = !tree3.multiple;"/>
	<tree id="tree3" fixedLayout="true" rows="5" multiple="true" checkmark="true">
		<treecols>
			<treecol label="Name"/>
			<treecol label="Description"/>
		</treecols>
		<treechildren>
			<treeitem>
				<treerow>
					<treecell label="Item 1"/>
					<treecell label="Item 1 description"/>
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item 2"/>
					<treecell label="Item 2 description"/>
				</treerow>
				<treechildren>
					<treeitem>
						<treerow>
							<treecell label="Item 2.1"/>
						</treerow>
						<treechildren>
							<treeitem>
								<treerow>
									<treecell label="Item 2.1.1"/>
								</treerow>
							</treeitem>
							<treeitem>
								<treerow>
									<treecell label="Item 2.1.2"/>
								</treerow>
							</treeitem>
						</treechildren>
					</treeitem>
					<treeitem>
						<treerow>
							<treecell label="Item 2.2"/>
							<treecell label="Item 2.2 is something who cares"/>
						</treerow>
					</treeitem>
				</treechildren>
			</treeitem>
			<treeitem label="Item 3"/>
		</treechildren>
	</tree>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Turn off checkmark
				singleTap(jq("@button:eq(0)"));
				sleep(500);
				verifyImage();

				// Turn checkmark back on
				singleTap(jq("@button:eq(0)"));
				sleep(500);
				
				// Turn off multiple selection
				singleTap(jq("@button:eq(1)"));
				sleep(500);
				verifyImage();
			});
	}
}