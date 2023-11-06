describe('Testing Register Form', () => {
    it('should render the form without crashing', () => {
      cy.visit('http://localhost:5173/register');
      cy.get('[data-testid="register-form"]').should('exist')  
    })

    it("should type form inputs" , () => {       
        cy.visit('http://localhost:5173/register');
        cy.get('[data-testid="register-form"]').should('exist')  
        cy.get('[data-testid="first-name"]').type('Somefirstname')  
        cy.get('[data-testid="last-name"]').type('Somelastname')  
        cy.get('[data-testid="password"]').type('Somepassword')  
        cy.get('[data-testid="confirm-password"]').type('Somepassword')  
        cy.get('[data-testid="birth-date"]').should('exist')

        cy.get('[data-testid="register-button"]').click();
        cy.get('[data-testid="register-form"]').submit(); 
    })

    it('should display error if inputs are empty and submit is clicked', () => {
      cy.visit('http://localhost:5173/register');

      cy.get('[data-testid="first-name-input"]').should('be.empty');
      cy.get('[data-testid="last-name-input"]').should('be.empty')  
      cy.get('[data-testid="email-input"]').should('be.empty')  
      cy.get('[data-testid="password-input"]').should('be.empty')  
      cy.get('[data-testid="confirm-password-input"]').should('be.empty')

      cy.get('[data-testid="register-button"]').click();
      cy.get('[data-testid="register-form"]').submit();   

      cy.get('[data-testid="first-name-error"]').should('be.visible')
      cy.get('[data-testid="last-name-error"]').should('be.visible')
      cy.get('[data-testid="email-error"]').should('be.visible')
      cy.get('[data-testid="password-error"]').should('be.visible')
    })

    it('should trigger on submit on button click', () => {
      cy.visit('http://localhost:5173/register');
      cy.get('[data-testid="register-button"]').click();
      cy.get('[data-testid="register-form"]').submit(); 
    })

    it('should navigate to Login page when Login Here is clicked', () => {
      cy.visit('http://localhost:5173/register');
      cy.get('[data-testid="login-redirect"]').should('exist').click();
      cy.location('pathname').should('eq', '/login')
    })
})
