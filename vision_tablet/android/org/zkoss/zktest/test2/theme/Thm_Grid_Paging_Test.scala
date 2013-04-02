package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Grid_Paging_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	Paging can be supported to locate at three position: Top, Bottom, and Both.
	<radiogroup
		onCheck="grid.pagingPosition = self.selectedItem.label;">
		<radio label="top" />
		<radio label="bottom" checked="true" />
		<radio label="both" />
	</radiogroup>
	<button label="Change Paging Mold">
		<attribute name="onClick">
		grid.pagingChild.mold = "os".equals(grid.pagingChild.mold) ? "default" : "os";
		</attribute>
	</button>
	<grid id="grid" mold="paging" pageSize="3">
		<columns>
			<column label="Index"/>
			<column label="Head 1"/>
			<column label="Head 2" align="center"/>
			<column label="Head 3" align="right"/>
		</columns>
		<rows>
			<row>
				1
				<listbox mold="select">
					<listitem label="AB"/>
					<listitem label="CD"/>
				</listbox>
				<datebox/>
				<textbox rows="3"/>
			</row>
			<row>
				2
				<label value="A11"/>
				<label value="A12"/>
				<label value="A13"/>
			</row>
			<row>
				3
				<checkbox checked="true" label="Option 1"/>
				<checkbox label="Option 2"/>
				<radiogroup>
					<radio label="Apple"/>
					<radio label="Orange" checked="true"/>
					<radio label="Lemon"/>
				</radiogroup>
			</row>
			<row>
				4
				<checkbox checked="true" label="Option 1"/>
				<checkbox label="Option 2"/>
				<radiogroup orient="vertical">
					<radio label="Apple"/>
					<radio label="Orange" checked="true"/>
					<radio label="Lemon"/>
				</radiogroup>
			</row>
			<row>
				5
				<listbox mold="select">
					<listitem label="AB"/>
					<listitem label="CD"/>
				</listbox>
				<datebox/>
				<textbox rows="3"/>
			</row>
			<row>
				6
				<label value="A11"/>
				<label value="A12"/>
				<label value="A13"/>
			</row>
			<row>
				7
				<checkbox checked="true" label="Option 1"/>
				<checkbox label="Option 2"/>
				<radiogroup>
					<radio label="Apple"/>
					<radio label="Orange" checked="true"/>
					<radio label="Lemon"/>
				</radiogroup>
			</row>
			<row>
				8
				<checkbox checked="true" label="Option 1"/>
				<checkbox label="Option 2"/>
				<radiogroup orient="vertical">
					<radio label="Apple"/>
					<radio label="Orange" checked="true"/>
					<radio label="Lemon"/>
				</radiogroup>
			</row>
		</rows>
	</grid>
	<separator/>
	Multi-paging
	<grid mold="paging" pageSize="5">
		<attribute name="onCreate">
			self.getPagingChild().setMold("os");
		</attribute>
		<columns menupopup="auto">
			<column label="Author"/>
			<column label="Title"/>
			<column label="Publisher"/>
			<column label="Hardcover"/>
		</columns>
		<rows>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
						<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
		</rows>
	</grid>
	<separator/>
	Only 1 Page
	<grid mold="paging" pageSize="5">
		<attribute name="onCreate">
			self.getPagingChild().setMold("os");
		</attribute>
		<columns menupopup="auto">
			<column label="Author"/>
			<column label="Title"/>
			<column label="Publisher"/>
			<column label="Hardcover"/>
		</columns>
		<rows>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
		</rows>
	</grid>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Paging on Top
				singleTap(jq("input[type=radio]:eq(0)"));
				sleep(500);
				verifyImage();
				
				// Paging on Top/Bottom
				singleTap(jq("input[type=radio]:eq(2)"));
				sleep(500);
				verifyImage();
				
				// Back to Bottom
				singleTap(jq("input[type=radio]:eq(1)"));
				sleep(500);
				
				// Change Paging Mold
				singleTap(jq("@button"));
				sleep(500);
				verifyImage();
				
				// Switch to Page 2
				singleTap(jq(".z-paging-os a:eq(1)"));
				sleep(500);
				verifyImage();
			});
	}
}