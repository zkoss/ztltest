package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Listbox_Header_1_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	Header and footer
	<hbox>
		<window title="auxhead, column, auxhead" border="normal"
			hflex="min">
			<listbox width="400px" fixedLayout="true">
				<auxhead>
					<auxheader label="A+B" colspan="2" />
					<auxheader label="C" />
				</auxhead>
				<listhead id="cs">
					<listheader label="Align Left" align="left" />
					<listheader label="Align Center" align="center"/>
					<listheader label="Align Right" align="right" />
				</listhead>
				<auxhead>
					<auxheader label="C+D" colspan="2" />
					<auxheader label="E" />
				</auxhead>
				<listitem>
					<listcell label="AA01" />
					<listcell label="BB01" />
					<listcell label="CC01" />
				</listitem>
				<listfoot>
					<listfooter label="footer 1" />
					<listfooter label="image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
					<listfooter label="image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
				</listfoot>
			</listbox>
		</window>
		<window title="column, auxhead, auxhead" border="normal"
			hflex="min">
			<listbox fixedLayout="true" width="400px">
				<listhead id="cs">
					<listheader label="Align Left" align="left" />
					<listheader label="Align Center" align="center"/>
					<listheader label="Align Right" align="right" />
				</listhead>
				<auxhead>
					<auxheader label="A+B" colspan="2" />
					<auxheader label="C" />
				</auxhead>
				<auxhead>
					<auxheader label="C"  />
					<auxheader label="D + E" colspan="2"/>
				</auxhead>
				<listitem>
					<listcell label="AA01" />
					<listcell label="BB01" />
					<listcell label="CC01" />
				</listitem>
				<listfoot>
					<listfooter label="footer 1" />
					<listfooter label="footer 2" />
					<listfooter label="footer 3" />
				</listfoot>
			</listbox>
		</window>
		
		<window title="auxhead, auxhead, column" border="normal"
			hflex="min">
			<listbox fixedLayout="true" width="400px">
				<auxhead>
					<auxheader label="A+B" colspan="2" />
					<auxheader label="C" />
				</auxhead>
				<auxhead>
					<auxheader label="C"  />
					<auxheader label="D + E" colspan="2"/>
				</auxhead>
				<listhead id="cs">
					<listheader label="Align Left" align="left"/>
					<listheader label="Align Center" align="center"/>
					<listheader label="Align Right" align="right"/>
				</listhead>
				<listitem>
					<listcell label="AA01" />
					<listcell label="BB01" />
					<listcell label="CC01" />
				</listitem>
				<listfoot>
					<listfooter label="footer 1" />
					<listfooter label="footer 2" />
					<listfooter label="footer 3" />
				</listfoot>
			</listbox>
		</window>
	</hbox>
	
	<div height="30px"></div>
	Sorting
	<hbox>
		<window title="sorting, sizeable" border="normal">
			<listbox fixedLayout="true" width="400px">
				<listhead sizable="true">
					<listheader align="center" width="40px"
						image="/img/Centigrade-Widget-Icons/ArrowsUpDown-16x16.png" />
					<listheader label="Subject" sort="auto" />
					<listheader label="Received" sort="auto" />
				</listhead>
				<listitem height="28px">
					<listcell
						image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
					<listcell label="ZK Jet 0.8.0 is released" />
					<listcell label="2008/11/17 17:41:29" />
				</listitem>
				<listitem height="28px">
					<listcell
						image="/img/Centigrade-Widget-Icons/ArrowDown-16x16.png" />
					<listcell
						label="URLs for iPhone-Optimized Google Sites" />
					<listcell label="2008/11/17 15:56:37" />
				</listitem>
				<listitem height="28px">
					<listcell label="&#160;" />
					<listcell label="Style Guide for ZK 3.5 released" />
					<listcell label="2008/11/14 13:23:07" />
				</listitem>
				<listitem height="28px">
					<listcell
						image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
					<listcell label="ZK Studio 0.9.0 released." />
					<listcell label="2008/11/16 10:26:37" />
				</listitem>
			</listbox>
		</window>
		
		<window title="sorting, sizeable with header" border="normal">
			<listbox fixedLayout="true" width="400px">
				<auxhead>
					<auxheader label="A+B (Align Center)" colspan="2" align="center"/>
					<auxheader label="C" />
				</auxhead>
				<listhead sizable="true">
					<listheader align="center" width="40px"
						image="/img/Centigrade-Widget-Icons/ArrowsUpDown-16x16.png" />
					<listheader label="Subject" sort="auto" />
					<listheader label="Received" sort="auto" />
				</listhead>
				<listitem height="28px">
					<listcell
						image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
					<listcell label="ZK Jet 0.8.0 is released" />
					<listcell label="2008/11/17 17:41:29" />
				</listitem>
				<listitem height="28px">
					<listcell
						image="/img/Centigrade-Widget-Icons/ArrowDown-16x16.png" />
					<listcell
						label="URLs for iPhone-Optimized Google Sites" />
					<listcell label="2008/11/17 15:56:37" />
				</listitem>
				<listitem height="28px">
					<listcell label="&#160;" />
					<listcell label="Style Guide for ZK 3.5 released" />
					<listcell label="2008/11/14 13:23:07" />
				</listitem>
				<listitem height="28px">
					<listcell
						image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
					<listcell label="ZK Studio 0.9.0 released." />
					<listcell label="2008/11/16 10:26:37" />
				</listitem>
				<listfoot>
					<listfooter label="footer" />
				</listfoot>
			</listbox>
		</window>
		
		<window title="sorting, resize, checkable" border="normal" >
			<listbox fixedLayout="true" width="400px" multiple="true" checkmark="true">
				<listhead sizable="true">
					<listheader align="center" width="40px"/>
					<listheader label="Subject" sort="auto" />
					<listheader label="Received" sort="auto" />
				</listhead>
				<auxhead>
					<auxheader label="A+B (Align Right)" colspan="2" align="right"/>
					<auxheader label="C" />
				</auxhead>
				<listitem height="28px">
					<listcell/>
					<listcell label="ZK Jet 0.8.0 is released" />
					<listcell label="2008/11/17 17:41:29" />
				</listitem>
				<listitem height="28px">
					<listcell />
					<listcell
						label="URLs for iPhone-Optimized Google Sites" />
					<listcell label="2008/11/17 15:56:37" />
				</listitem>
				<listitem height="28px">
					<listcell/>
					<listcell label="Style Guide for ZK 3.5 released" />
					<listcell label="2008/11/14 13:23:07" />
				</listitem>
				<listitem height="28px">
					<listcell/>
					<listcell label="ZK Studio 0.9.0 released." />
					<listcell label="2008/11/16 10:26:37" />
				</listitem>
				<listfoot>
					<listfooter label="" />
					<listfooter label="image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
					<listfooter label="image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
				</listfoot>
			</listbox>
		</window>
	</hbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}