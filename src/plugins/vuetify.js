import 'vuetify/styles';
import { createVuetify } from 'vuetify';
import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';

// Import Material Design Icons (MDI) font
import '@mdi/font/css/materialdesignicons.min.css';

const darkTheme = {
    dark: true,
    icons: {
        iconfont: 'mdi',
    },
    colors: {
        background: "#15202b",
        surface: "#25384b",
        primary: "#004479",
        'primary-text': "#e1e1e1",
        secondary: "#2e3b44",
        error: "#f44336",
        info: "#2196F3",
        success: "#4caf50",
        warning: "#fb8c00",
    }
};

const lightTheme = {
    dark: false,
    icons: {
        iconfont: 'mdi', // Specify the icon font for the light theme (MDI)
    },
    colors: {
        background: '#F5F5F5',
        surface: '#FFFFFF',
        primary: '#1976D2',
        'primary-text': '#000000',
        secondary: '#9E9E9E',
        error: '#B00020',
        info: '#2196F3',
        success: '#4CAF50',
        warning: '#FB8C00',
    }
};

const vuetify = createVuetify({
    components,
    directives,
    theme: {
        defaultTheme: 'lightTheme',
        themes: {
            lightTheme,
            darkTheme,
        },
    },
});

export default vuetify;