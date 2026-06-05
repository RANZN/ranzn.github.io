package com.ranjan.myportfolio.navigation

import com.ranjan.myportfolio.data.models.NavigationSection
import kotlinx.browser.window
import org.w3c.dom.events.Event

/**
 * Browser-specific implementation of NavigationManager
 * Handles URL hash-based navigation for web platform
 */
class BrowserNavigationManager : NavigationManager {
    
    private var navigationListener: ((NavigationSection) -> Unit)? = null
    private val popStateHandler: (Event) -> Unit = {
        val section = getCurrentSection()
        navigationListener?.invoke(section)
    }

    override fun getCurrentSection(): NavigationSection {
        val hash = window.location.hash
        return if (hash.startsWith("#")) {
            NavigationSection.fromUrlHash(hash.substring(1))
        } else {
            NavigationSection.ABOUT
        }
    }

    override fun updateUrl(section: NavigationSection) {
        val newUrl = "${window.location.pathname}#${section.title}"
        window.history.pushState(null, "", newUrl)
    }

    override fun setupNavigationListener(onNavigationChange: (NavigationSection) -> Unit) {
        navigationListener = onNavigationChange
        window.addEventListener("popstate", popStateHandler)
    }

    override fun removeNavigationListener() {
        window.removeEventListener("popstate", popStateHandler)
        navigationListener = null
    }
}

