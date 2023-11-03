describe('Testing Landing Page', () => {
  it('passes', () => {
    cy.visit('http://localhost:5173/landing-page');
    
    cy.get('[data-testid="landing-page-logo"]').should('exist').should('have.text', 'TaskFlow')
    cy.get('[data-testid="landing-page-login-btn"]').should('exist').should('have.text', 'Login')
    cy.get('[data-testid="landing-page-register-btn"]').should('exist').should('have.text', 'Register Now')
    cy.get('[data-testid="landing-page-title"]').should('exist').should('have.text', 'Task Management For Your Company')
  })

  it('navigates to login when Login btn is clicked', () => {
    cy.visit('http://localhost:5173/landing-page');
    cy.viewport(2440, 1920)

    cy.get('[data-testid="landing-page-login-btn"]').should('exist').click();
    cy.location("pathname").should('equal', '/login');
  }) 

  it('navigates to register when Register Now btn is clicked', () => {
    cy.visit('http://localhost:5173/landing-page');
    cy.viewport(2440, 1920)

    cy.get('[data-testid="landing-page-register-btn"]').should('exist').click();
    cy.location("pathname").should('equal', '/register');
  }) 
})