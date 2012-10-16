package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Listbox_Header_2_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	Grouping
	<hbox>
		<window title="grouping" border="normal">
			<listbox fixedLayout="true" width="400px">
				<listhead sizable="true">
					<listheader label="Brand" />
					<listheader label="Price"  width="100px"/>
					<listheader label="Hard Drive Capacity" width="150px"/>
				</listhead>
					<listgroup label="Dell" open="false"/>
					<listitem>
						<listcell label="Dell E4500 2.2GHz"/>
						<listcell label="$261.00" />
						<listcell label="500GB"/>
					</listitem>
					<listitem>
						<listcell label="XP-Pro Slim Dell-Inspiron-530-s"/>
						<listcell label="$498.93" />
						<listcell label="500GB"/>				
					</listitem>
					<listitem>
						<listcell label="Dell P4 3.2 GHz"/>
						<listcell label="$377.99" />
						<listcell label="500GB"/>				
					</listitem>
					<listgroup label="Compaq"/>
					<listitem>
						<listcell label="Compaq SR5113WM"/>
						<listcell label="$279.00" />
						<listcell label="160GB"/>				
					</listitem>
					<listitem>
						<listcell label="Compaq HP XW4200"/>
						<listcell label="$980"/>
						<listcell label="500GB"/>				
					</listitem>
					<listgroupfoot>
						<listcell label="cell in groupfoot"/>
						<listcell label=""/>
						<listcell label=""/>
					</listgroupfoot>
					<listfoot>
						<listfooter label="" />
						<listfooter label="image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
					</listfoot>
			</listbox>
		</window>
		
		<window title="grouping with height" border="normal">
			<listbox fixedLayout="true" width="400px" height="200px">
				<listhead sizable="true">
					<listheader label="Brand" />
					<listheader label="Price"  width="100px"/>
					<listheader label="Hard Drive Capacity" width="150px"/>
				</listhead>
					<listgroup label="Dell" />
					<listitem>
						<listcell label="Dell E4500 2.2GHz"/>
						<listcell label="$261.00" />
						<listcell label="500GB"/>
					</listitem>
					<listitem>
						<listcell label="XP-Pro Slim Dell-Inspiron-530-s"/>
						<listcell label="$498.93" />
						<listcell label="500GB"/>				
					</listitem>
					<listitem>
						<listcell label="Dell P4 3.2 GHz"/>
						<listcell label="$377.99" />
						<listcell label="500GB"/>				
					</listitem>
					<listgroup label="Compaq"/>
					<listitem>
						<listcell label="Compaq SR5113WM"/>
						<listcell label="$279.00" />
						<listcell label="160GB"/>				
					</listitem>
					<listitem>
						<listcell label="Compaq HP XW4200"/>
						<listcell label="$980"/>
						<listcell label="500GB"/>				
					</listitem>
					<listgroupfoot>
						<listcell label="cell in groupfoot"/>
						<listcell label=""/>
						<listcell label=""/>
					</listgroupfoot>
			</listbox>
		</window>
		<window title="grouping with paging" border="normal">
			<radiogroup
				onCheck="listbox.pagingPosition = self.selectedItem.label">
				<radio label="top" />
				<radio label="bottom" checked="true" />
				<radio label="both" />
			</radiogroup>
			<button label="Change Paging Mold">
				<attribute name="onClick">
				listbox.pagingChild.mold = "os".equals(listbox.pagingChild.mold) ? "default" : "os";
				</attribute>
			</button>
			<listbox id="listbox" fixedLayout="true" width="400px" mold="paging" pageSize="3">
				<listhead sizable="true">
					<listheader label="Brand" />
					<listheader label="Price"  width="100px"/>
					<listheader label="Hard Drive Capacity" width="150px"/>
				</listhead>
					<listgroup label="Dell"/>
					<listitem>
						<listcell label="Dell E4500 2.2GHz"/>
						<listcell label="$261.00" />
						<listcell label="500GB"/>
					</listitem>
					<listitem>
						<listcell label="XP-Pro Slim Dell-Inspiron-530-s"/>
						<listcell label="$498.93" />
						<listcell label="500GB"/>				
					</listitem>
					<listitem>
						<listcell label="Dell P4 3.2 GHz"/>
						<listcell label="$377.99" />
						<listcell label="500GB"/>				
					</listitem>
					<listgroup label="Compaq"/>
					<listitem>
						<listcell label="Compaq SR5113WM"/>
						<listcell label="$279.00" />
						<listcell label="160GB"/>				
					</listitem>
					<listitem>
						<listcell label="Compaq HP XW4200"/>
						<listcell label="$980"/>
						<listcell label="500GB"/>				
					</listitem>
					<listgroupfoot>
						<listcell label="cell in groupfoot"/>
						<listcell label=""/>
						<listcell label=""/>
					</listgroupfoot>
			</listbox>
		</window>		
	</hbox>

	<div height="30px"></div>
	<hbox>
		<window
			title="Complex header: with toobarbutton and menu inside"
			border="normal" hflex="min">
			<listbox>
				<auxhead>
					<auxheader colspan="2">
						<label id="span">ss</label>
						<textbox onChange='span.value = self.value' />
						<datebox />
						ssss
					</auxheader>
				</auxhead>
				<listhead sizable="true">
					<listheader sort="auto">
						<toolbarbutton label="toobarbutton"
							onClick='alert(self.label)' />
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
						<button label="label" onClick='alert("button")' />
						<datebox />
					</listheader>
					<listheader>
						<listbox rows="1" mold="select">
							<listitem label="option1" />
							<listitem label="option2" />
							<listitem label="option3" />
						</listbox>
					</listheader>
				</listhead>
				<listitem>
					<listcell label="Mary" />
					<listcell label="FEMALE" />
				</listitem>
				<listitem>
					<listcell label="John" />
					<listcell label="MALE" />
				</listitem>
				<listitem>
					<listcell label="Jane" />
					<listcell label="FEMALE" />
				</listitem>
				<listitem>
					<listcell label="Henry" />
					<listcell label="MALE" />
				</listitem>
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