import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z30-grid-0003TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z30-grid-0003TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:h="http://www.w3.org/1999/xhtml">
			<h:h3> Test Grid with paging</h:h3>
			<h:p>
			See if the sorted result printed in console is same as the data collection displayed in Browser.
			</h:p>
			<vbox>
			<toolbarbutton label="B30-1823959.zul" href="B30-1823959.zul"/>
			<toolbarbutton label="B30-1824604.zul" href="B30-1824604.zul"/>
			</vbox>
				<separator/>
				<zscript>
					import org.zkoss.zktest.util.*;
					import java.util.*;
					import org.zkoss.zul.*;
					
					ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel();
					Comparator asc = new RowLabelComparator(true),
					dsc = new RowLabelComparator(false);
				</zscript>
				<vbox>
					<button id="btn1" label="Invalidate Model" onClick="strset.invalidate()"/>
					<button id="btn2" label="Invalidate Grid" onClick="g.invalidate()"/>
					<grid id="g" mold="paging" model="\${strset}" width="400px" pageSize="13" activePage="10">
						<columns sizable="true">
							<column label="Type" sortAscending="\${asc}" sortDescending="\${dsc}"
							 sortDirection="ascending"/>
						</columns>
					</grid>
				</vbox>
			</zk>`,
	);
	let uuid_cafe = await ClientFunction(
		() => zk.Desktop._dt.$f("g", true).paging.uuid,
	)();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("g", true).getWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("400px"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("g", true).rows.nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("13"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("g", true)
						.rows.firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Option 130"));
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("g", true).paging.$n().offsetHeight,
		)(),
	);
	await t.expect(10 < verifyVariable_cafe_0_0).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("g", true).paging.getActivePage(),
				)(),
			),
		)
		.eql(ztl.normalizeText("10"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("g", true).getWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("400px"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("g", true).rows.nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("13"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("g", true)
						.rows.firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Option 130"));
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("g", true).paging.$n().offsetHeight,
		)(),
	);
	await t.expect(10 < verifyVariable_cafe_1_1).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("g", true).paging.getActivePage(),
				)(),
			),
		)
		.eql(ztl.normalizeText("10"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("g", true).getWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("400px"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("g", true).rows.nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("13"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("g", true)
						.rows.firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Option 130"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("g", true).paging.$n().offsetHeight,
				)(),
			),
		)
		.notEql(ztl.normalizeText("0"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("g", true).paging.getActivePage(),
				)(),
			),
		)
		.eql(ztl.normalizeText("10"));
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("g", true).paging).find(
					".z-paging-first",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("g", true).rows.nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("13"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("g", true)
						.rows.firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Option 0"));
	let verifyVariable_cafe_2_2 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("g", true).paging.$n().offsetHeight,
		)(),
	);
	await t.expect(10 < verifyVariable_cafe_2_2).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("g", true).paging.getActivePage(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("g", true).paging).find(
					".z-paging-next",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("g", true).rows.nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("13"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("g", true)
						.rows.firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Option 13"));
	let verifyVariable_cafe_3_3 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("g", true).paging.$n().offsetHeight,
		)(),
	);
	await t.expect(10 < verifyVariable_cafe_3_3).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("g", true).paging.getActivePage(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("g", true).paging).find(
					".z-paging-previous",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("g", true).rows.nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("13"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("g", true)
						.rows.firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Option 0"));
	let verifyVariable_cafe_4_4 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("g", true).paging.$n().offsetHeight,
		)(),
	);
	await t.expect(10 < verifyVariable_cafe_4_4).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("g", true).paging.getActivePage(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("g", true).paging).find(
					".z-paging-last",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("g", true).rows.nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("g", true)
						.rows.firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Option 9997"));
	let verifyVariable_cafe_5_5 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("g", true).paging.$n().offsetHeight,
		)(),
	);
	await t.expect(10 < verifyVariable_cafe_5_5).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("g", true).paging.getActivePage(),
				)(),
			),
		)
		.eql(ztl.normalizeText("769"));
});
