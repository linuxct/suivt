module.exports = {
    base: '/',
    head: [['link', { rel: 'icon', href: '/images/favicon.png' }]],
    title: 'Shared User ID Validation Tool',
    description: "TODO",
    themeConfig: {
        logo: '/images/logo_transparent.png',
        darkMode: false,
        repo: 'linuxct/suivt'
    },
    plugins: [
        '@vuepress/back-to-top'
    ]
}