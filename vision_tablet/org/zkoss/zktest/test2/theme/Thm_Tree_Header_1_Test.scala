package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Tree_Header_1_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
<hbox>
	<window title="auxhead, treecols, auxhead, selected treeitem" border="normal">
		<tree width="400px">
			<auxhead>
				<auxheader label="A+B" colspan="2"/>
				<auxheader label="C"/>
			</auxhead>
			<treecols>
				<treecol label="Align Left" align="left" />
				<treecol label="Align Center" align="center"/>
				<treecol label="Align Right" align="right"/>
			</treecols>
			<auxhead>
				<auxheader label="C" />
				<auxheader label="D + E" colspan="2"/>
			</auxhead>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="AA01" />
						<treecell label="BB01" />
						<treecell label="CC01" />
					</treerow>
					<treechildren>
						<treeitem selected="true">
							<treerow>
								<treecell label="A-1" />
								<treecell label="B" />
								<treecell label="C" />
							</treerow>
						</treeitem>
						<treeitem>
							<treerow>
								<treecell label="A-2" />
								<treecell label="B" />
								<treecell label="C" />
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="AA02" />
					</treerow>
				</treeitem>
			</treechildren>
			<treefoot>
				<treefooter label="footer 1"/>
				<treefooter label="image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
				<treefooter label="image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
			</treefoot>
		</tree>
	</window>
	
	<window title="treecols, auxhead, auxhead, open = false" border="normal">
		<tree width="400px">
			<treecols>
				<treecol label="Align Left" align="left" />
				<treecol label="Align Center" align="center" />
				<treecol label="Align Right" align="right" />
			</treecols>
			<auxhead>
				<auxheader label="A+B" colspan="2"/>
				<auxheader label="C"/>
			</auxhead>
			<auxhead>
				<auxheader label="C" />
				<auxheader label="D + E" colspan="2"/>
			</auxhead>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="AA01" />
						<treecell label="BB01" />
						<treecell label="CC01" />
					</treerow>
				</treeitem>
				<treeitem open="false">
					<treerow>
						<treecell label="AA02" />
					</treerow>
					<treechildren>
						<treeitem >
							<treerow>
								<treecell label="A-1" />
								<treecell label="B" />
								<treecell label="C" />
							</treerow>
						</treeitem>
						<treeitem>
							<treerow>
								<treecell label="A-2" />
								<treecell label="B" />
								<treecell label="C" />
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
			</treechildren>
			<treefoot>
				<treefooter label="footer 1"/>
				<treefooter label="footer 2"/>
				<treefooter label="footer 3"/>
			</treefoot>
		</tree>
	</window>
	
	<window title="auxhead, auxhead, treecols" border="normal">
		<tree width="400px">
			<auxhead>
				<auxheader label="A+B" colspan="2"/>
				<auxheader label="C"/>
			</auxhead>
			<auxhead>
				<auxheader label="C" />
				<auxheader label="D + E" colspan="2"/>
			</auxhead>
			<treecols>
				<treecol label="Align Left" align="left" />
				<treecol label="Align Center" align="center" />
				<treecol label="Align Right" align="right" />
			</treecols>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="AA01" />
						<treecell label="BB01" />
						<treecell label="CC01" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="AA02" />
					</treerow>
				</treeitem>
			</treechildren>
			<treefoot>
				<treefooter label="footer 1"/>
				<treefooter label="footer 2"/>
				<treefooter label="footer 3"/>
			</treefoot>
		</tree>
	</window>
</hbox>
<div height="30px"></div>
<hbox>
	<window title="only treecols" border="normal">
		<tree width="400px">
			<treecols>
				<treecol label="Align Left" align="left" />
				<treecol label="Align Center" align="center" />
				<treecol label="Align Right" align="right" />
			</treecols>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="AA01" />
						<treecell label="BB01" />
						<treecell label="CC01" />
					</treerow>
				</treeitem>
			</treechildren>
			<treefoot>
				<treefooter label="footer 1"/>
				<treefooter label="footer width Image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
				<treefooter label="footer 3"/>
			</treefoot>
		</tree>
	</window>
	<window title="only auxhead: it should not display the header" border="normal">
		<tree width="400px">
			<auxhead>
				<auxheader label="A+B" colspan="2"/>
				<auxheader label="C"/>
			</auxhead>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="AA01" />
						<treecell label="BB01" />
						<treecell label="CC01" />
					</treerow>
				</treeitem>
			</treechildren>
			<treefoot>
				<treefooter label="footer 1"/>
				<treefooter label="footer width Image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
				<treefooter label="footer 3"/>
			</treefoot>
		</tree>
	</window>
	<window title="sizeable treecols" border="normal">
		<tree width="400px">
			<treecols sizable="true">
				<treecol label="Align Left" align="left" />
				<treecol label="Align Center" align="center" />
				<treecol label="Align Right" align="right" />
			</treecols>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="AA01" />
						<treecell label="BB01" />
						<treecell label="CC01" />
					</treerow>
				</treeitem>
			</treechildren>
			<treefoot>
				<treefooter label="footer 1"/>
				<treefooter label="footer width Image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
				<treefooter label="footer 3"/>
			</treefoot>
		</tree>
	</window>
</hbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}