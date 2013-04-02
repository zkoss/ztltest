package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Menu_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<hbox>
		<custom-attributes org.zkoss.zul.image.preload='true'/>
		<window title="Menubar (horizontal)" border="normal"
			width="550px" height="400px">
			<label>Horizontal</label>
			<menubar id="menubar" width="100%">
				<menu label="Project"
					image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
					<menupopup>
						<menuitem
							image="/img/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png"
							label="New" onClick="alert(self.label)" />
						<menuitem
							image="/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png"
							label="Open" onClick="alert(self.label)" />
						<menuitem
							image="/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png"
							label="Save" onClick="alert(self.label)" />
						<menuseparator />
						<menuitem label="Exit"
							image="/img/Centigrade-Widget-Icons/DoorOpen-16x16.png"
							onClick="alert(self.label)" />
					</menupopup>
				</menu>
				<menuseparator />
				<menu label="Help"
					image="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png">
					<menupopup>
						<menuitem label="Index"
							onClick="alert(self.label)" />
						<menu label="About">
							<menupopup>
								<menuitem label="About ZK"
									onClick="alert(self.label)" />
								<menuitem label="About Potix"
									onClick="alert(self.label)" />
							</menupopup>
						</menu>
					</menupopup>
				</menu>
				<menu
					image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
					<menupopup>
						<menuitem label="Index"
							onClick="alert(self.label)" />
					</menupopup>
				</menu>
				<menuitem label="Menuitem" onClick="alert(self.label)" />
				<menuitem label="Menuitem" onClick="alert(self.label)"
						  image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png" 
						  disabled="true"  />
			</menubar>
			<div height="10px" />
			
			<label>Vertical: Default width is 100%</label>
			<menubar width="100%" orient="vertical">
				<menu label="Project"
					image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
					<menupopup>
						<menuitem
							image="/img/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png"
							label="New" onClick="alert(self.label)" />
						<menuitem
							image="/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png"
							label="Open" onClick="alert(self.label)" />
						<menuitem
							image="/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png"
							label="Save" onClick="alert(self.label)" />
						<menuseparator />
				<menuitem autocheck="true" checked="true" label="Menuitem" onClick="alert(self.label)" />
						<menuitem label="Exit"
							image="/img/Centigrade-Widget-Icons/DoorOpen-16x16.png"
							onClick="alert(self.label)" />
					</menupopup>
				</menu>
				<menu label="Help"
					image="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png">
					<menupopup>
						<menuitem label="Index"
							onClick="alert(self.label)" />
						<menu label="About">
							<menupopup>
								<menuitem label="About ZK"
									onClick="alert(self.label)" />
								<menuitem label="About Potix"
									onClick="alert(self.label)" />
							</menupopup>
						</menu>
					</menupopup>
				</menu>
				<menu
					image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
					<menupopup>
						<menuitem label="Index"
							onClick="alert(self.label)" />
					</menupopup>
				</menu>
				<menuseparator />
				<menuitem label="Menuitem" onClick="alert(self.label)" />
				<menuitem disabled="true" label="Menuitem" onClick="alert(self.label)" />
			</menubar>
		</window>
		<window title="Menupopup" border="normal" width="300px"
			height="300px">
			<div height="50px"></div>
			<button label="Open menupopup">
				<attribute name="onClick">
	popuop.open(self);
</attribute>
			</button>
			<menupopup id="popuop">
				<menuitem
					image="/img/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png"
					label="New" onClick="alert(self.label)" />
				<menuitem
					image="/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png"
					label="Open" onClick="alert(self.label)" />
				<menuitem
					image="/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png"
					label="Save" onClick="alert(self.label)" />
				<menuseparator />
				<menuitem label="Exit"
					image="/img/Centigrade-Widget-Icons/DoorOpen-16x16.png"
					onClick="alert(self.label)" />
			</menupopup>
		</window>
		<window title="Auto drop menubar" border="normal"
			height="300px">
			<menubar id="menubar" width="100%">
				<attribute name="onCreate">
	self.setAutodrop(true);
</attribute>
				<menu label="Project"
					image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
					<menupopup>
						<menuitem
							image="/img/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png"
							label="New" onClick="alert(self.label)" />
						<menuitem
							image="/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png"
							label="Open" onClick="alert(self.label)" />
						<menuitem
							image="/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png"
							label="Save" onClick="alert(self.label)" />
						<menuseparator />
						<menuitem label="Exit"
							image="/img/Centigrade-Widget-Icons/DoorOpen-16x16.png"
							onClick="alert(self.label)" />
					</menupopup>
				</menu>
				<menu label="Help"
					image="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png">
					<menupopup>
						<menuitem label="Index"
							onClick="alert(self.label)" />
						<menu label="About">
							<menupopup>
								<menuitem label="About ZK"
									onClick="alert(self.label)" />
								<menuitem label="About Potix"
									onClick="alert(self.label)" />
							</menupopup>
						</menu>
					</menupopup>
				</menu>
				<menu
					image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
					<menupopup>
						<menuitem label="Index"
							onClick="alert(self.label)" />
						<menu label="Color Picker"
							content="#color=#184dc6" />
					</menupopup>
				</menu>
			</menubar>
		</window>
	</hbox>
	<hbox>
		<window title="Scrollable Menupopup" border="normal"
			width="350px" height="300px">
			<label>Horizontal Menubar</label>
			<menubar id="menubar" width="200px;">
				<attribute name="onCreate">
					self.setScrollable(true);
				</attribute>
				<menu label="Project"
					image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
					<menupopup>
						<menuitem
							image="/img/Centigrade-Widget-Icons/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png"
							label="New" onClick="alert(self.label)" />
						<menuitem
							image="/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png"
							label="Open" onClick="alert(self.label)" />
						<menuitem
							image="/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png"
							label="Save" onClick="alert(self.label)" />
						<menuseparator />
						<menuitem label="Exit"
							image="/img/Centigrade-Widget-Icons/DoorOpen-16x16.png"
							onClick="alert(self.label)" />
					</menupopup>
				</menu>
				<menu label="Help"
					image="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png">
					<menupopup>
						<menuitem label="Index"
							onClick="alert(self.label)" />
						<menu label="About">
							<menupopup>
								<menuitem label="About ZK"
									onClick="alert(self.label)" />
								<menuitem label="About Potix"
									onClick="alert(self.label)" />
							</menupopup>
						</menu>
					</menupopup>
				</menu>
				<menu
					image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
					<menupopup>
						<menuitem label="Index"
							onClick="alert(self.label)" />
						<menu label="Color Picker"
							content="#color=#184dc6" />
					</menupopup>
				</menu>
			</menubar>
		</window>
		<window title="Colorbox in Menu" border="normal" width="350px"
			height="300px">
			<menubar id="menubar" width="100%">
				<menu
					image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
					<menupopup>
						<menuitem label="Index"
							onClick="alert(self.label)" />
						<menu label="Color Picker"
							content="#color=#184dc6" />
					</menupopup>
				</menu>
			</menubar>
			<checkbox label="Vertical orient">
				<attribute name="onCheck">
					menubar.orient = self.checked ? "vertical" : "horizontal";
				</attribute>
			</checkbox>
		</window>
	</hbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Verify Horizontal Menubar
				// =============================================================
				// First level menu popup
				singleTap(jq("@menu[label=Project]:eq(0)"));
				sleep(500);
				verifyImage();
				// Tap again to close 'Project' menu
				singleTap(jq("@menu[label=Project]:eq(0)"));

				// Second level menu popup
				singleTap(jq("@menu[label=Help]:eq(0)"));
				sleep(500);
				singleTap(jq("@menu[label=About]:eq(0)"));
				verifyImage();
				
				// Verify Vertical Menubar
				// =============================================================
				// First level menu popup
				singleTap(jq("@menu[label=Project]:eq(1)"));
				sleep(500);
				verifyImage();
				singleTap(jq("@menu[label=Project]:eq(1)"));
				
				// Second level menu popup
				singleTap(jq("@menu[label=Help]:eq(1)"));
				sleep(500);
				singleTap(jq("@menu[label=About]:eq(1)"));
				verifyImage();
				
				// Verify Menu Popup
				// =============================================================
				singleTap(jq("@button:eq(0)"));
				sleep(500);
				verifyImage();
				
				// Verify Colorbox in Menu
				singleTap(jq("@menu:eq(14)"));
				sleep(500);
				singleTap(jq("@menu:eq(15)"));
				verifyImage();
			});
	}
}