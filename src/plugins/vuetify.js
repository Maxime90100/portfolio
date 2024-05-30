import 'vuetify/styles';
import { createVuetify } from 'vuetify';
import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';

// Import Material Design Icons (MDI) font
import '@mdi/font/css/materialdesignicons.min.css';

const defaultTheme = {
    dark: true,
    icons: {
        iconfont: 'mdi',
    },
    colors: {
        background: "#020e10",
        surface: "#1e2526",
        primary: "#90cbc7",
        secondary: "#363c3d"
    }
};

const vuetify = createVuetify({
    components,
    directives,
    theme: {
        defaultTheme: 'defaultTheme',
        themes: {
            defaultTheme
        },
    },
});

export default vuetify;