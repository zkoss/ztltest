package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Grid_2_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk>
	<hbox>
		<window
			title="auxhead, column, auxhead"
			border="normal" >
			<grid fixedLayout="true" width="360px">
				<auxhead>
					<auxheader label="A+B" colspan="2"/>
					<auxheader label="C"/>
				</auxhead>
				<columns id="cs">
					<column label="Align Left" align="left" width="120px"/>
					<column label="Align Center" align="center" width="120px"/>
					<column label="Align Right" align="right" width="120px"/>
				</columns>
				<auxhead>
					<auxheader label="C+D" colspan="2"/>
					<auxheader label="E"/>
				</auxhead>
				<rows>
					<row>
						<label value="AA01"/>
						<label value="BB01"/>
						<label value="CC01"/>
					</row>
				</rows>
				<foot>
					<footer label="footer 1"/>
					<footer label="footer 2"/>
					<footer label="footer 3"/>
				</foot>
			</grid>
		</window>
		
		<window title="column, auxhead, auxhead" border="normal" >
			<grid fixedLayout="true" width="360px">
				<columns id="cs">
					<column label="Align Left" align="left" width="120px"/>
					<column label="Align Center" align="center" width="120px"/>
					<column label="Align Right" align="right" width="120px"/>
				</columns>
				<auxhead>
					<auxheader label="A+B" colspan="2"/>
					<auxheader label="C"/>
				</auxhead>
				<auxhead>
					<auxheader label="C+D" colspan="2"/>
					<auxheader label="E"/>
				</auxhead>
				<rows>
					<row>
						<label value="AA01"/>
						<label value="BB01"/>
						<label value="CC01"/>
					</row>
				</rows>
				<foot>
					<footer label="footer 1"/>
					<footer label="footer 2"/>
					<footer label="footer 3"/>
				</foot>
			</grid>
		</window>
		
		<window title="column, auxhead, auxhead" border="normal">
			<grid fixedLayout="true" width="360px">
				<auxhead>
					<auxheader label="A+B" colspan="2"/>
					<auxheader label="C"/>
				</auxhead>
				<auxhead>
					<auxheader label="C+D" colspan="2"/>
					<auxheader label="E"/>
				</auxhead>
				<columns id="cs">
					<column label="Align Left" align="left" width="120px"/>
					<column label="Align Center" align="center" width="120px"/>
					<column label="Align Right" align="right" width="120px"/>
				</columns>
				<rows>
					<row>
						<label value="AA01"/>
						<label value="BB01"/>
						<label value="CC01"/>
					</row>
				</rows>
				<foot>
					<footer label="footer 1"/>
					<footer label="footer 2"/>
					<footer label="footer 3"/>
				</foot>
			</grid>
		</window>
	</hbox>
	
	<hbox>
		<window title="Only column" border="normal" >
			<grid fixedLayout="true" width="360px">
				<columns id="cs">
					<column label="Align Left" align="left" width="120px"/>
					<column label="Align Center" align="center" width="120px"/>
					<column label="Align Right" align="right" width="120px"/>
				</columns>
				<rows>
					<row>
						<label value="AA01"/>
						<label value="BB01"/>
						<label value="CC01"/>
					</row>
				</rows>
				<foot>
					<footer label="footer 1"/>
					<footer label="footer 2"/>
				</foot>
			</grid>
		</window>
		
		<window title="Only auxhead: It shouldn't display auxhead" border="normal" >
			<grid fixedLayout="true" width="360px">
				<auxhead>
					<auxheader label="A+B" colspan="2"/>
					<auxheader label="C"/>
				</auxhead>
				<rows>
					<row>
						<label value="AA01"/>
						<label value="BB01"/>
						<label value="CC01"/>
					</row>
				</rows>
				<foot>
					<footer label="footer 1"/>
					<footer label="footer 2"/>
				</foot>
			</grid>
		</window>
		
		<window title="No auxhead, No columns" border="normal" >
			<grid fixedLayout="true" width="360px">
				<auxhead>
					<auxheader label="A+B" colspan="2"/>
					<auxheader label="C"/>
				</auxhead>
				<rows>
					<row>
						<label value="AA01"/>
						<label value="BB01"/>
						<label value="CC01"/>
					</row>
				</rows>
				<foot>
					<footer label="footer 1"/>
					<footer label="footer 2"/>
				</foot>
			</grid>
		</window>
	</hbox>
	<hbox>
		<window title="Textbox and datebox in auxheader" border="normal" >
			<grid fixedLayout="true" width="360px">
				<columns id="cs">
					<column label="Align Left" align="left" width="120px"/>
					<column label="Align Center" align="center" width="120px"/>
					<column label="Align Right" align="right" width="120px"/>
				</columns>
				<auxhead>
					<auxheader label="A+B" colspan="2"/>
					<auxheader label="C"/>
				</auxhead>
				<auxhead>
					<auxheader colspan="2">
						<label id="span">ss</label>
						<textbox onChange='span.value = self.value' />
						<datebox />
						ssss
					</auxheader>
				</auxhead>
				<rows>
					<row>
						<label value="AA01"/>
						<label value="BB01"/>
						<label value="CC01"/>
					</row>
					<row>
						<label value="AA01"/>
						<label value="BB01"/>
						<label value="CC01"/>
					</row>
					<row>
						<label value="AA01"/>
						<label value="BB01"/>
						<label value="CC01"/>
					</row>
				</rows>
				<foot>
					<footer label="footer 1"/>
					<footer label="footer 2"/>
				</foot>
			</grid>
		</window>
		<window title="Embedded menubar, button, datebox and Listbox in column" border="normal">
			<grid fixedLayout="true" width="720px">
				<columns sizable="true">
					<column label="Type">
						<menubar>
							<menu label="File">
								<menupopup>
									<menuitem label="New"
										onClick="alert(self.label)" />
									<menuitem label="Open"
										onClick="alert(self.label)" />
									<menuitem label="Save"
										onClick="alert(self.label)" />
									<menuseparator />
									<menuitem label="Exit"
										onClick="alert(self.label)" />
								</menupopup>
							</menu>
							<menu label="Help">
								<menupopup>
									<menuitem label="Index"
										onClick="alert(self.label)" />
									<menu label="About">
										<menupopup>
											<menuitem label="About ZK"
												onClick="alert(self.label)" />
											<menuitem
												label="About Potix" onClick="alert(self.label)" />
										</menupopup>
									</menu>
								</menupopup>
							</menu>
						</menubar>
						<button label="lable" onClick='alert("button")' />
						<datebox />
					</column>
					<column label="Content">
						<listbox rows="1" mold="select">
							<listitem label="option1" />
							<listitem label="option2" />
							<listitem label="option3" />
						</listbox>
					</column>
				</columns>
				<rows>
					<row>
						<label value="File:" />
						<textbox width="99%" />
					</row>
					<row>
						<label value="Type:" />
						<hbox>
							<listbox rows="1" mold="select">
								<listitem label="Java Files,(*.java)" />
								<listitem label="All Files,(*.*)" />
							</listbox>
							<button label="Browse..." />
						</hbox>
					</row>
					<row>
						<label value="Options:" />
						<textbox rows="3" width="99%" />
					</row>
				</rows>
			</grid>
		</window>
	</hbox>
	<grid emptyMessage="This Grid is empty.">
		<columns>
			<column label="Col Title">Col Content</column>
		</columns>
	</grid>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
