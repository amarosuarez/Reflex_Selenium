import reflex as rx

from reflex_tests import reflex_tests

def buscadores() -> rx.Component:
    return rx.vstack(
        rx.heading("Página de buscadores"),
        rx.list(
            rx.list_item(rx.link("Google", href="https://www.google.com", id="google", is_external=True)),
            rx.list_item(rx.link("Bing", href="https://www.bing.com", id="bing", is_external=True)),
            rx.list_item(rx.link("Baidu", href="https://www.baidu.com", id="baidu", is_external=True)),
        ),
        rx.button(
            rx.link(
                "Volver",
                href="/"
            )
        )
    )

app = rx.App()
app.add_page(reflex_tests, route="/")
