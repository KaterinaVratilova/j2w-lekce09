[#ftl]
[@c.page title="Dotazy"]
    <h1>Dotazy</h1>

    <h4>Zobrazit všechny záznamy</h4>
    <form action="/" method="get">
        <div class="row">
            <div class="ten columns">Seřazené dle příjmení a jména
            </div>
            <div class="two columns submit">
                <button class="button-primary" type="submit">Zobrazit</button>
            </div>
        </div>
    </form>

    <form action="/dle-data-narozeni" method="get">
        <div class="row">
            <div class="ten columns">Sařezané dle data narození
            </div>
            <div class="two columns submit">
                <button class="button-primary" type="submit">Zobrazit</button>
            </div>
        </div>
    </form>

    <h4>Podle roku narození</h4>
    <form action="/rok-narozeni" method="get">
        <div class="row">
            <div class="five columns">
                <label for="od">Od</label>
                <input id="od" name="od" class="u-full-width" type="number" min="1930" max="2020" required>
            </div>
            <div class="five columns">
                <label for="do">Do</label>
                <input id="do" name="do" class="u-full-width" type="number" min="1930" max="2020" required>
            </div>
            <div class="two columns submit">
                <button class="button-primary" type="submit">Zobrazit</button>
            </div>
        </div>
    </form>

    <h4>Podle příjmení</h4>
    <form action="/prijmeni" method="get">
        <div class="row">
            <div class="ten columns">
                <label for="prijmeni">Začátek příjmení</label>
                <input id="prijmeni" name="prijmeni" class="u-full-width" type="search" required>
            </div>
            <div class="two columns submit">
                <button class="button-primary" type="submit">Zobrazit</button>
            </div>
        </div>
    </form>

    <h4>Podle obce</h4>
    <form action="/obec" method="get">
        <div class="row">
            <div class="ten columns">
                <label for="obec">Obec</label>
                <input id="obec" name="obec" class="u-full-width" type="search" required>
            </div>
            <div class="two columns submit">
                <button class="button-primary" type="submit">Zobrazit</button>
            </div>
        </div>
    </form>

    <h4>Podle věku</h4>
    <form action="/minimalni-vek" method="get">
        <div class="row">
            <div class="ten columns">
                <label for="vek">Starší než</label>
                <input id="vek" name="vek" class="u-full-width" type="number" placeholder="18" required>
            </div>
            <div class="two columns submit">
                <button class="button-primary" type="submit">Zobrazit</button>
            </div>
        </div>
    </form>
[/@c.page]
