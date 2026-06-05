package com.ranjan.myportfolio.navigation

import com.ranjan.myportfolio.data.models.NavigationSection

/**
 * Interface for managing browser navigation and URL state
 * Abstracts platform-specific navigation implementation
 */
interface NavigationManager {
    /**
     * Gets the current section from the URL
     */
    fun getCurrentSection(): NavigationSection

    /**
     * Updates the URL to reflect the selected section
     */
    fun updateUrl(section: NavigationSection)

    /**
     * Sets up a listener for browser back/forward navigation events
     * @param onNavigationChange callback invoked when navigation changes
     */
    fun setupNavigationListener(onNavigationChange: (NavigationSection) -> Unit)

    /**
     * Removes the navigation listener (cleanup)
     */
    fun removeNavigationListener()
}

