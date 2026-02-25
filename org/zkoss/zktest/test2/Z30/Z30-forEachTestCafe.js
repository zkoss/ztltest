import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z30-forEachTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z30-forEachTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
				<zscript>
			List items = new java.util.AbstractList() {
				public int size() {
					return 100;
				}
				public Object get(int j) {
					return new Integer(j);
					}
			};
				int end = 50;
				</zscript>
				Show 5 to 50 and select 10.
				<listbox id="l" rows="50">
					<listitem forEach="\${items}" forEachBegin="5" forEachEnd="\${end}"
					selected="\${forEachStatus.index == 10}">
					<listcell label="\${each}"/>
					<listcell label="\${each}"/>
					<listcell label="\${each}"/>
					<listcell label="\${each}"/>
					</listitem>
				</listbox>
			</window>`,
	);
	await t
		.expect(ztl.normalizeText("5"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(0)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("6"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(1)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("7"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(2)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("8"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(3)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("9"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(4)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("10"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(5)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("11"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(6)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("12"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(7)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("13"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(8)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("14"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(9)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("15"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(10)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("16"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(11)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("17"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(12)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("18"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(13)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("19"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(14)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("20"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(15)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("21"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(16)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("22"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(17)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("23"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(18)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("24"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(19)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("25"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(20)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("26"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(21)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("27"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(22)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("28"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(23)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("29"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(24)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("30"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(25)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("31"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(26)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("32"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(27)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("33"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(28)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("34"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(29)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("35"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(30)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("36"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(31)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("37"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(32)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("38"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(33)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("39"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(34)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("40"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(35)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("41"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(36)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("42"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(37)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("43"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(38)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("44"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(39)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("45"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(40)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("46"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(41)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("47"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(42)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("48"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(43)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("49"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(44)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("50"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem")
						.eq(45)
						.find("@listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("10"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem-selected")
						.find(".z-listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
});
